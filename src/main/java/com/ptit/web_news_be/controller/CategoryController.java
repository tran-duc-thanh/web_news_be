package com.ptit.web_news_be.controller;

import com.ptit.web_news_be.entity.CategorysEntity;
import com.ptit.web_news_be.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<List<CategorysEntity>> getAll () {
        List<CategorysEntity> results = categoryService.getAll();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<CategorysEntity> getOne (@PathVariable("id") Long id) {
        CategorysEntity result = categoryService.getOne(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<CategorysEntity> save (@RequestBody CategorysEntity category) {
        CategorysEntity results = categoryService.addCategory(category);
        return ResponseEntity.ok(results);
    }
}
