package Model.Service;

import Model.Entity.CategoryElement;
import Model.Repozitory.CategoryElRepo;


import java.util.List;

public class CategoryElService {

    private static CategoryElService service = new CategoryElService();

    public static CategoryElService getInstance() {
        return service;
    }


    public void insertCategoryElement(CategoryElement categoryElement) {
        CategoryElRepo.getInstance().insertCategoryElement(categoryElement);
    }

    public void updateCategoryElement(CategoryElement categoryElement) {
        CategoryElRepo.getInstance().updateCategoryElement(categoryElement);
    }

    public void removeCategoryElement(CategoryElement categoryElement) {
        CategoryElRepo.getInstance().removeCategoryElement(categoryElement);
    }

    public List<CategoryElement> selectCategoryElement() {
        return CategoryElRepo.getInstance().selectCategoryElement();
    }
}
