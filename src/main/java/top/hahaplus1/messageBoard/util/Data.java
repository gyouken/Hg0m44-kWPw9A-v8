package top.hahaplus1.messageBoard.util;

import java.util.List;

public class Data {
    int status;
    List<Message> data;

    public Data(int status, List<Message> data) {
        this.status = status;
        this.data = data;
    }
}
