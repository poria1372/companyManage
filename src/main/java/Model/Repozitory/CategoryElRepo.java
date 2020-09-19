package Model.Repozitory;

import Common.JPA;
import Model.Entity.CategoryElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryElRepo {
    private static CategoryElRepo service= new CategoryElRepo();
    private CategoryElRepo(){

    }
    public static CategoryElRepo getInstance(){
        return service;
    }


    public void insertCategoryElement(CategoryElement categoryElement) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(categoryElement);


        entityTransaction.commit();
        entityManager.close();
    }

    public void updateCategoryElement(CategoryElement categoryElement) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(categoryElement);


        entityTransaction.commit();
        entityManager.close();
    }

    public void removeCategoryElement(CategoryElement categoryElement) {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        categoryElement = entityManager.merge(categoryElement);
        entityManager.remove(categoryElement);


        entityTransaction.commit();
        entityManager.close();

    }

    public List<CategoryElement> selectCategoryElement() {
        EntityManager entityManager = JPA.getEntityManager();
        List<CategoryElement> categoryElementList = entityManager.createQuery("select o from CategoryElement o").getResultList();
        entityManager.close();
        return categoryElementList;
    }
}
