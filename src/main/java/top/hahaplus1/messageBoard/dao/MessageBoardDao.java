package top.hahaplus1.messageBoard.dao;

import top.hahaplus1.messageBoard.util.JDBCUtil;
import top.hahaplus1.messageBoard.util.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MessageBoardDao {
    public void insertMessage(Message message) {
        Connection con = JDBCUtil.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.addBatch("insert into message_board values(NULL,'" + message.getUsername() + "','" + message.getText() + "'," + message.getPid() + ")");
            stmt.executeBatch();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Message> findMessagesByPid(int pid) {
        Connection con = JDBCUtil.getConnection();
        List<Message> list = new ArrayList<Message>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM message_board WHERE pid = " + pid);
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setPid(rs.getInt("pid"));
                message.setText(rs.getString("text"));
                message.setUsername(rs.getString("username"));
                list.add(message);
            }
            JDBCUtil.close(rs, stmt, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
