package Controller.Email;

import Log.Log4j;
import Model.Entity.Email;
import Model.Service.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/email/insertEmail")
public class insertEmail extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Email email = new Email();
            email.setSenderId(req.getParameter("senderId"));
            email.setSubject(req.getParameter("subject"));
            email.setContent(req.getParameter("content"));
            EmailService.getInstance().insertEmail(email);
            resp.sendRedirect("/email/selectEmail");

        } catch (Exception e) {
            Log4j.getLogger().info("insertEmail have a exception");

        }

    }
}
