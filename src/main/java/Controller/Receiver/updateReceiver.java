package Controller.Receiver;

import Log.Log4j;
import Model.Entity.Receiver;
import Model.Service.RecieverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receiver/updateReceiver")
public class updateReceiver extends HttpServlet {


    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Receiver receiver = new Receiver();
            receiver.setReceiver(req.getParameter("receiver"));
            receiver.setId(Integer.parseInt(req.getParameter("id")));
            RecieverService.getInstance().updateReceiver(receiver);
            resp.sendRedirect("/receiver/selectReceiver");
        } catch (Exception e) {
            Log4j.getLogger().info("updateReceiver have a Controller.Exception");
        }

    }
}
