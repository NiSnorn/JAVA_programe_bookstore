package ThirdWithMySQL;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //读取文件并获值
        try {
            //创建集合
            Properties pro = new Properties();
            //获取src路径下的文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("ThirdWithMySQL/jdbc.properties") ;
            String path = res.getPath();
            //加载文件
            pro.load(new FileReader(path));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(PreparedStatement pstmt, Connection conn){
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void close(ResultSet res,PreparedStatement pstmt, Connection conn){
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

