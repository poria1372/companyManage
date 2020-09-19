package Model.Service;

import Model.Entity.Employee;
import Model.Repozitory.EmployeeRepo;


import java.util.List;

public class EmployeeService {
    private static EmployeeService service = new EmployeeService();


    public static EmployeeService getInstance() {
        return service;
    }

    public void insertEmployee(Employee employee) {
        EmployeeRepo.getInstance().insertEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        EmployeeRepo.getInstance().updateEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        EmployeeRepo.getInstance().removeEmployee(employee);
    }

    public List<Employee> selectEmployee() {
        return EmployeeRepo.getInstance().selectEmployee();
    }
}
