package top.hahaplus1.messageBoard.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import top.hahaplus1.messageBoard.service.MessageBoardService;
import top.hahaplus1.messageBoard.util.Message;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
    String ERROR = "{\"status\":\"10001\"}";
    String OK = "{\"status\":\"10000\"}";
    MessageBoardService messageBoardService = new MessageBoardService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String text = request.getParameter("text");
        int pid = Integer.parseInt(request.getParameter("pid"));
        Message message = new Message(username, text, pid);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        response.getOutputStream()
                )
        );
        if (messageBoardService.insertContent(message)) {
            writer.write(OK);
        } else {
            writer.write(ERROR);
        }
        writer.flush();
        writer.close();
    }
}
