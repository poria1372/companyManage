package Model.Repozitory;

import Common.JPA;
import Model.Entity.Leave;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LeaveRepo {

    private static LeaveRepo service= new LeaveRepo();
    private LeaveRepo(){

    }
    public static LeaveRepo getInstance(){
        return  service;
    }

    public void insertLeave(Leave leave) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(leave);


        entityTransaction.commit();
        entityManager.close();
    }

    public void updateLeave(Leave leave) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(leave);


        entityTransaction.commit();
        entityManager.close();
    }

    public void removeLeave(Leave leave) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        leave = entityManager.merge(leave);
        entityManager.remove(leave);

        entityTransaction.commit();
        entityManager.close();

    }

    public List<Leave> selectLeave() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Leave> leaveList = entityManager.createQuery("select o from Leave o").getResultList();
        entityManager.close();
        return leaveList;
    }
}
