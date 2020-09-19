package Controller.Email;

import Log.Log4j;
import Model.Service.EmailService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/email/selectEmail")
public class selectEmail  extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", EmailService.getInstance().selectEmail());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        }catch (Exception e){
            Log4j.getLogger().info("select Email have a exception");
        }

    }
}
