package com.ptit.web_news_be.controller;

import com.ptit.web_news_be.auth.user.User;
import com.ptit.web_news_be.auth.user.UserRepository;
import com.ptit.web_news_be.entity.CategorysEntity;
import com.ptit.web_news_be.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserRepository userRepository;

    public CategoryController(CategoryService categoryService, UserRepository userRepository) {
        this.categoryService = categoryService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<List<CategorysEntity>> getAll () {
        List<CategorysEntity> results = categoryService.getAll();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/favorite-genre")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<List<CategorysEntity>> getFavoriteGenre (@RequestParam String username) {
        List<CategorysEntity> results = categoryService.getFavoriteGenre(username);
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
