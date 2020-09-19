package Model.Repozitory;

import Common.JPA;
import Model.Entity.Attachment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AttachmentRepo {
    private static AttachmentRepo service= new AttachmentRepo();
    private AttachmentRepo(){

    }
    public static AttachmentRepo getInstance(){
        return service;
    }
    public void insertAttachment(Attachment attachment) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(attachment);

        entityTransaction.commit();
        entityManager.close();
    }

    public void updateAttachment(Attachment attachment) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(attachment);


        entityTransaction.commit();
        entityManager.close();
    }

    public void removeAttachment(Attachment attachment) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        attachment = entityManager.merge(attachment);
        entityManager.remove(attachment);

        entityTransaction.commit();
        entityManager.close();

    }

    public List<Attachment> selectAttachment() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Attachment> attachmentList = entityManager.createQuery("select o from Attachment o").getResultList();
        entityManager.close();
        return attachmentList;
    }
}
