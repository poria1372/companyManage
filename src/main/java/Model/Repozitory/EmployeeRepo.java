package Model.Repozitory;

import Common.JPA;
import Model.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeRepo {
    private static EmployeeRepo service = new EmployeeRepo();

    private EmployeeRepo() {

    }

    public static EmployeeRepo getInstance() {
        return service;
    }

    public void insertEmployee(Employee employee) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(employee);

        entityTransaction.commit();
        entityManager.close();

    }

    public void updateEmployee(Employee employee) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(employee);

        entityTransaction.commit();
        entityManager.close();
    }

    public void removeEmployee(Employee employee) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        employee = entityManager.merge(employee);
        entityManager.remove(employee);


        entityTransaction.commit();
        entityManager.close();
    }

    public List<Employee> selectEmployee() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Employee> employeeList = entityManager.createQuery("select o from Employee  o").getResultList();
        entityManager.close();
        return employeeList;
    }
}
