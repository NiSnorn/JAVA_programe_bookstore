package ThirdWithMySQL.Editor;


import ThirdWithMySQL.JDBCUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class DDL extends Basic{//create
    public void Create() throws SQLException {
        Scanner sc = new Scanner(System.in);
        JDBCUtils.getConnection();
        String str = "Create table ";
    }

}
