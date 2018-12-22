package top.hahaplus1.messageBoard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/message_board" + "?serverTimezone=GMT%2B8", "root", "059eakaH1.9m");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs, Statement statement, Connection con) {
        try {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
            if (con != null)
                con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}