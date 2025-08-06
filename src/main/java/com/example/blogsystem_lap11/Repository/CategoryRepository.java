package com.example.blogsystem_lap11.Repository;

import com.example.blogsystem_lap11.Model.Category;
import com.example.blogsystem_lap11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> {





    @Query("select c from Category c where c.category_id = ?1")
    Category getCategoryByCategoryId(Integer category_id);
}
