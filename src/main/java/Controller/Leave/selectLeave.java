package Controller.Leave;

import Log.Log4j;
import Model.Service.LeaveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/leave/selectLeave")
public class selectLeave extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", LeaveService.getInstance().selectLeave());
            req.getRequestDispatcher("/leave.jsp").forward(req,resp);
        }catch (Exception e){
            Log4j.getLogger().info("selectLeave have a exception");
        }

    }
}
