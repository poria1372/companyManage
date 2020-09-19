package Model.Service;

import Model.Entity.Category;
import Model.Repozitory.CategoryRepo;


import java.util.List;

public class CategoryService {
    private static CategoryService service = new CategoryService();

    public static CategoryService getInstance() {
        return service;
    }

    public void insertCategory(Category category) {
        CategoryRepo.getInstance().insertCategory(category);
    }

    public void updateCategory(Category category) {
        CategoryRepo.getInstance().updateCategory(category);
    }

    public void removeCategory(Category category) {
        CategoryRepo.getInstance().removeCategory(category);
    }

    public List<Category> selectCategory() {
        return CategoryRepo.getInstance().selectCategory();
    }
}
