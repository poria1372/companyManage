package Controller.Email;

import Model.Entity.EmailUtility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String resultMessage = "";
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "ایمیل با موفقیت ارسال شد";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "ایمیل یا پسوورد را اشتباه وارد کرده اید";
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }
    }
}