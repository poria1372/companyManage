package Controller.Receiver;

import Log.Log4j;
import Model.Service.RecieverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receiver/selectReceiver")
public class selectReceiver extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", RecieverService.getInstance().selectReciver());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        }catch (Exception e){
            Log4j.getLogger().info("selectReceiver have a exception");
        }

    }
}
