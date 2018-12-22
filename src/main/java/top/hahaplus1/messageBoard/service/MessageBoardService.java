package top.hahaplus1.messageBoard.service;

import com.google.gson.Gson;
import top.hahaplus1.messageBoard.dao.MessageBoardDao;
import top.hahaplus1.messageBoard.util.*;

import java.util.List;

public class MessageBoardService {
    MessageBoardDao messageBoardDao = new MessageBoardDao();

    public boolean insertContent(Message message) {
        if (message.getUsername() != null && message.getText() != null) {
            messageBoardDao.insertMessage(message);
            return true;
        }
        return false;
    }

    private List<Message> findContentChild(Message message) {
        List<Message> list = messageBoardDao.findMessagesByPid(message.getId());
        for (Message it : list) {
            List<Message> childList = findContentChild(it);
            it.setChildContent(childList);
        }
        return list;
    }

    public List<Message> findAllMessages() {
        List<Message> list = messageBoardDao.findMessagesByPid(0);
        for (Message it : list) {
            List<Message> childList = findContentChild(it);
            it.setChildContent(childList);
        }
        return list;
    }

    public String messagesToJson(List<Message> messageList) {
        Gson gson = new Gson();
        Data data = new Data(10000, messageList);
        return gson.toJson(data);
    }
}
