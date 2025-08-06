package com.example.blogsystem_lap11.Controller;


import com.example.blogsystem_lap11.API.ApiResponse;
import com.example.blogsystem_lap11.Model.Category;
import com.example.blogsystem_lap11.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {



    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Category category  , Errors errors) {

        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }        categoryService.addCategory(category);
        return ResponseEntity.ok(new ApiResponse("Category added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Category category , Errors errors) {


        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }
        categoryService.updateCategory(id, category);

            return ResponseEntity.ok(new ApiResponse("Category updated successfully"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
         categoryService.deleteCategory(id);
            return ResponseEntity.ok(new ApiResponse("Category deleted successfully"));

    }


}

