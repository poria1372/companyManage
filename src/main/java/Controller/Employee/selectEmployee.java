package Controller.Employee;

import Log.Log4j;
import Model.Service.EmployeeService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/selectEmployee")
public class selectEmployee extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", EmployeeService.getInstance().selectEmployee());
            req.getRequestDispatcher("/employee.jsp").forward(req, resp);

        } catch (Exception e) {
            Log4j.getLogger().info("selectEmployee have a exception");
        }
    }
}
