package com.example.blogsystem_lap11.Service;


import com.example.blogsystem_lap11.API.ApiException;
import com.example.blogsystem_lap11.Model.Category;
import com.example.blogsystem_lap11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category newCategory) {
        Category oldCategory = categoryRepository.getCategoryByCategoryId(id);
        if (oldCategory == null) {
            throw new ApiException("The Post Not found");
        }

        oldCategory.setName(newCategory.getName());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.getCategoryByCategoryId(id);
        if (category == null) {
            throw new ApiException("The Post Not found");
        }
        categoryRepository.delete(category);

    }

}
