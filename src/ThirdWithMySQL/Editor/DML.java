package ThirdWithMySQL.Editor;



import ThirdWithMySQL.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DML extends Basic{//add,delete,update

    Scanner sc = new Scanner(System.in );
    Connection conn = null;


    public void Add() {
        conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("书籍编号：");
        this.id = sc.nextInt();
        System.out.println("书籍名称：");
        this.bookname = sc.next();
        System.out.println("作者姓名 ：");
        this.authorname = sc.next();
        System.out.println("添加数量：");
        this.num = sc.nextInt();
        System.out.println("书籍价格：");
        this.pri = sc.nextDouble();

        PreparedStatement pstmt = null;
        try {
            String str = "insert into basic_program_db.Bookstore values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.bookname);
            pstmt.setString(3, this.authorname);
            pstmt.setInt(4, this.num);
            pstmt.setDouble(5, this.pri);
            pstmt.executeUpdate();
            System.out.println("添加成功");
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
    public void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("书籍编号：");
        id = sc.nextInt();
        PreparedStatement pstmt = null;
        try {
            String str = "delete from basic_program_db.Bookstore where id = ?";
            Connection conn=JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, id);
            int n = pstmt.executeUpdate();
            if (n<=0){
                System.out.println("删除失败");
            }else {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(pstmt, conn);
        }


    }
    public void Commit()  {

        try {
            String str = "commit ";
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(str);
            int n = pstmt.executeUpdate();
            if (n<0){
                System.out.println("数据保存失败");
            }else{
                System.out.println("数据保持成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
