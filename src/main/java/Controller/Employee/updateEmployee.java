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

@WebServlet("/employee/updateEmployee")
public class updateEmployee extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(req.getParameter("id")));
            employee.setName(req.getParameter("name"));
            employee.setFamily(req.getParameter("family"));
            employee.setFatherName(req.getParameter("fatherName"));
            employee.setIdCode(req.getParameter("idCode"));
            employee.setNationalCode(req.getParameter("nationalCode"));
            employee.setAddress(req.getParameter("address"));
            employee.setPhoneNumber(Long.parseLong(req.getParameter("phoneNumber")));
            employee.setEmail(req.getParameter("email"));
            employee.setField(req.getParameter("field"));
            employee.setCertificate(req.getParameter("certificate"));
            employee.setSurface(req.getParameter("surface"));
            employee.setSupervisor(req.getParameter("supervisor"));
            EmployeeService.getInstance().updateEmployee(employee);
            resp.sendRedirect("/employee/selectEmployee");
        } catch (Exception e) {
            Log4j.getLogger().info("UpdateEmployee have a exception");

        }

    }
}
