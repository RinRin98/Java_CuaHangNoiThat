package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.Security.HasRoleADMIN;
import com.example.DoAn_Java_API.model.Category;
        import com.example.DoAn_Java_API.services.CategoryService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @HasRoleADMIN
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    @HasRoleADMIN
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setProducts(updatedCategory.getProducts());
            categoryService.updateCategory(existingCategory);
            return ResponseEntity.ok(existingCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @HasRoleADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
