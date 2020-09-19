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

@WebServlet("/email/updateEmail")
public class updateEmail extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Email email = new Email();
            email.setSubject(req.getParameter("subject"));
            email.setContent(req.getParameter("content"));
            email.setId(Integer.parseInt(req.getParameter("id")));
            EmailService.getInstance().updateEmail(email);
            resp.sendRedirect("/email/selectEmail");

        } catch (Exception e) {
            Log4j.getLogger().info("updateEmail have a exception");
        }

    }
}
