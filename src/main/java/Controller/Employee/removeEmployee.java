package Controller.Employee;

import Log.Log4j;
import Model.Entity.Employee;
import Model.Service.EmployeeService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/removeEmployee")
public class removeEmployee extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(req.getParameter("id")));
            EmployeeService.getInstance().removeEmployee(employee);
            resp.sendRedirect("/employee/selectEmployee");

        } catch (Exception e) {
            Log4j.getLogger().info("removeEmployee have a exception");

        }

    }
}

