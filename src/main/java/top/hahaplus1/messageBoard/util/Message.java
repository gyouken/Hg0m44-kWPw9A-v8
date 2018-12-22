package top.hahaplus1.messageBoard.util;

import java.util.List;

public class Message {

    private int id;

    private int pid;

    private String username;

    private String text;

    private List<Message> childContent;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public int getPid() {
        return pid;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChildContent(List<Message> childContent) {
        this.childContent = childContent;
    }

    public String getText() {
        return text;
    }

    public List<Message> getChildContent() {
        return childContent;
    }

    public Message(String username, String text, int pid) {
        this.username = username;
        this.text = text;
        this.pid = pid;
    }
}
