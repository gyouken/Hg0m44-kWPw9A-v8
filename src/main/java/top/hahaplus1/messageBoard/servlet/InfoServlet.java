package top.hahaplus1.messageBoard.servlet;

import top.hahaplus1.messageBoard.service.MessageBoardService;
import top.hahaplus1.messageBoard.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    MessageBoardService messageBoardService = new MessageBoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Message> messageList = messageBoardService.findAllMessages();
        String res = messageBoardService.messagesToJson(messageList);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        resp.getOutputStream()
                )
        );
        writer.write(res);
        writer.flush();
        writer.close();
    }
}
