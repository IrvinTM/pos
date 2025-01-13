package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.irvin.pos.entities.Category;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws PropertyAlreadyExistException{
        Category c = categoryService.addCategory(category);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public Page<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category c = categoryService.updateCategorie(category);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Category> deleteCategory(@RequestParam long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
