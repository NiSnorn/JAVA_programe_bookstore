package ThirdWithMySQL;


import ThirdWithMySQL.Editor.Basic;
import ThirdWithMySQL.Editor.DML;
import ThirdWithMySQL.Editor.DQL;


import java.sql.*;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("——————————欢迎来到我的书城——————————");
            System.out.println("* 1、员工登录  2、书客登录  3、退出  *");
            System.out.println("---------------------------------");

            int choice = sc.nextInt();
            if (choice ==1){
                System.out.println("——————————————员工登录——————————————");
                System.out.println("请输入EID：");
                String EID = sc.next();
                System.out.println("请输入PSW：");
                String PSW = sc.next();
                boolean fn = new View().Login(EID,PSW);
                if (fn){
                    System.out.println("登录成功");
                    while (true) {
                    System.out.println("——————————————员工登录——————————————");
                    System.out.println("1.浏览书架");
                    System.out.println("2.添加图书");
                    System.out.println("3.删除图书");
                    System.out.println("4.关闭书城");
                    System.out.println("请输入您的选择：");
                    int choice1 = sc.nextInt();
                        if (choice1 == 1) {
                            DQL dql = new DQL();
                            dql.print();
                        }
                        if (choice1 == 2) {
                            new DML().Add();
                        }
                        if (choice1 == 3) {
                            new DML().Delete();

                        }
                        if (choice1 == 4) {
                            new DML().Commit();
                            break;
                        }
                    }
                }else{
                    System.out.println("账号或密码错误，请重试。");
                }

            }
            if (choice == 2){
                while(true){
                    System.out.println("1.浏览书架");
                    System.out.println("2.查询图书");
                    System.out.println("3.离开书城");
                    System.out.println("请输入您的选择：");
                    int choice2 = sc.nextInt();
                    if (choice2==1){
                        DQL dql = new DQL();
                        dql.print();
                    }
                    if (choice2==2){
                        System.out.println("请输入查询书籍的编号：");
                        Basic b = DQL.FindOne(sc.nextInt());
                        if (b ==null){
                            System.out.println("查无此书");
                        }else {
                            System.out.println(
                                    "书籍编码："+b.getId()+"  书籍名称："+b.getBookname()+"  作者："+b.getAuthorname()+"  剩余数量："+b.getNum()+"  建议售价："+b.getPri()+"元");
                        }
                    }
                    if (choice2 == 3) {
                        break;
                    }

                }
            }

            if (choice==3){
                break;
            }

        }
    }

    public boolean Login(String EID ,String PSW) {
        if (EID ==null|| PSW == null) {
            return false;
        }
        ResultSet res = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            String str = "select * from basic_program_db.BookstoreEditer where EID = ? and PSW = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1,EID);
            pstmt.setString(2,PSW);
            res = pstmt.executeQuery();
            return res.next();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, pstmt, conn);
        }


    }


}
