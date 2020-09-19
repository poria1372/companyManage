package Model.Repozitory;

import Common.JPA;
import Model.Entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryRepo {
    private static CategoryRepo service= new CategoryRepo();
    private CategoryRepo(){

    }
    public static CategoryRepo getInstance(){
        return service;
    }

    public void insertCategory(Category category) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(category);


        entityTransaction.commit();
        entityManager.close();
    }

    public void updateCategory(Category category) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(category);


        entityTransaction.commit();
        entityManager.close();
    }

    public void removeCategory(Category category) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        category = entityManager.merge(category);
        entityManager.remove(category);

        entityTransaction.commit();
        entityManager.close();

    }

    public List<Category> selectCategory() {
        EntityManager entityManager = JPA.getEntityManager();
        List<Category> categoryList = entityManager.createQuery("select o from Category o").getResultList();
        entityManager.close();
        return categoryList;
    }
}
