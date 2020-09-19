package Controller.Leave;

import Log.Log4j;
import Model.Entity.Leave;
import Model.Service.LeaveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/leave/removeLeave")
public class removeLeave extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Leave leave = new Leave();
            leave.setId(Integer.parseInt(req.getParameter("id")));
            LeaveService.getInstance().removeLeave(leave);
            resp.sendRedirect("/leave/selectLeave");
        } catch (Exception e) {
            Log4j.getLogger().info("removeLeave have a exception");
        }

    }
}
