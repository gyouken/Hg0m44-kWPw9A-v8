import org.junit.Test;
import top.hahaplus1.messageBoard.dao.MessageBoardDao;
import top.hahaplus1.messageBoard.util.JDBCUtil;
import top.hahaplus1.messageBoard.util.Message;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    @Test
    public void test() {
        Message message = new Message("test1", "test03", 1);
        System.out.println(message.getUsername());
        System.out.println(message.getText());
        System.out.println(message.getPid());
        MessageBoardDao messageBoardDao = new MessageBoardDao();
        messageBoardDao.insertMessage(message);
    }
}

