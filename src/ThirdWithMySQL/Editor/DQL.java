package ThirdWithMySQL.Editor;


import ThirdWithMySQL.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DQL extends Basic{//Show
     Basic b = new Basic();



    public  void print() {
        List<Basic> list = new DQL().findAll();
        for (int i = 0; i < list.size(); i++) {
            b = list.get(i);
            System.out.println(
                    "书籍编码："+b.getId()+"  书籍名称："+b.getBookname()+"  作者："+b.getAuthorname()+"  剩余数量："+b.getNum()+"  建议售价："+b.getPri()+"元");
        }


    }

    public List<Basic> findAll() {
        ResultSet res = null;
        PreparedStatement pstmt = null;
        Connection conn = JDBCUtils.getConnection();
        List<Basic>list;

        try {
            String str = "select * from basic_program_db.Bookstore";
            pstmt = conn.prepareStatement(str);
            res = pstmt.executeQuery();
            Basic b = null;
            list = new ArrayList<Basic>();
            while (res.next()){
                int id = res.getInt("id");
                String bn = res.getString("bookname");
                String an = res.getString("authorname");
                int num = res.getInt("num");
                double pr= res.getDouble("pri");
                b = new Basic();
                b.setId(id);
                b.setBookname(bn);
                b.setAuthorname(an);
                b.setNum(num);
                b.setPri(pr);
                list.add(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(res,pstmt,conn);
        }

        return list;
    }

    public static Basic FindOne(int id) {

        ResultSet res = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        Basic b = null;
        try {
            String str = "select * from basic_program_db.Bookstore where id = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1,id);
            res = pstmt.executeQuery();
            if (res.next()){

                id = res.getInt("id");
                String bn = res.getString("bookname");
                String an = res.getString("authorname");
                int num = res.getInt("num");
                double pr= res.getDouble("pri");
                b = new Basic();
                b.setId(id);
                b.setBookname(bn);
                b.setAuthorname(an);
                b.setNum(num);
                b.setPri(pr);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, pstmt, conn);
        }
        return b ;
    }



}
