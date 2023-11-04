package com.ptit.web_news_be.controller;

import com.ptit.web_news_be.entity.ArticlesEntity;
import com.ptit.web_news_be.service.ArticlesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
    private final ArticlesService articlesService;

    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticlesEntity> getOne (@PathVariable("id") Long id) {
        Optional<ArticlesEntity> article = articlesService.getOne(id);
        if (article.isPresent()) {
            return ResponseEntity.ok(article.get());
        } else {
            return (ResponseEntity<ArticlesEntity>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/category/{categoryID}")
    public ResponseEntity<List<ArticlesEntity>> getAllByCategory (@PathVariable("categoryID") Long categoryID) {
        return ResponseEntity.ok(articlesService.getArticlesByCategory(categoryID));
    }
}
