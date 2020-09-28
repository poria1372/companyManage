package Model.Repozitory;

import Common.JPA;
import Model.Entity.Email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Properties;

public class EmailRepo {
    private static EmailRepo service = new EmailRepo();

    private EmailRepo() {
    }

    public static EmailRepo getInstance() {
        return service;
    }
    public void insertEmail(Email email) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(email);

        entityTransaction.commit();
        entityManager.close();

    }

    public void updateEmail(Email email) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(email);

        entityTransaction.commit();
        entityManager.close();
    }

    public void removeEmail(Email email) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        email = entityManager.merge(email);
        entityManager.remove(email);

        entityTransaction.commit();
        entityManager.close();
    }

    public List<Email> selectEmail() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Email> emailList = entityManager.createQuery("select o from Email o").getResultList();
        entityManager.close();
        return emailList;
    }
}
