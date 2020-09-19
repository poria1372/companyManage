package Model.Repozitory;

import Common.JPA;
import Model.Entity.Receiver;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ReceiverRepo {
    private static ReceiverRepo service= new ReceiverRepo();
    private ReceiverRepo(){

    }
    public static ReceiverRepo getInstance(){
        return service;
    }


    public void insertReceiver(Receiver receiver) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(receiver);


        entityTransaction.commit();
        entityManager.close();
    }

    public void updateReceiver(Receiver receiver) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(receiver);


        entityTransaction.commit();
        entityManager.close();
    }

    public void removeReceiver(Receiver receiver) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        receiver = entityManager.merge(receiver);
        entityManager.remove(receiver);

        entityTransaction.commit();
        entityManager.close();

    }

    public List<Receiver> selectReceiver() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Receiver> receiverList = entityManager.createQuery("select o from Receiver o").getResultList();
        entityManager.close();
        return receiverList;

    }
}
