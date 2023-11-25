package com.ptit.web_news_be.controller;

import com.ptit.web_news_be.entity.ArticlesEntity;
import com.ptit.web_news_be.service.ArticlesService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<ArticlesEntity> getOne(@PathVariable("id") Long id, @RequestParam String username) {
        Optional<ArticlesEntity> article = articlesService.getOne(id, username);
        if (article.isPresent()) {
            return ResponseEntity.ok(article.get());
        } else {
            return (ResponseEntity<ArticlesEntity>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/category/{categoryID}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<Page<ArticlesEntity>> getAllByCategory(@PathVariable("categoryID") Long categoryID,
                                                                 @RequestParam Integer page,
                                                                 @RequestParam Integer size,
                                                                 @RequestParam String sort) {
        return ResponseEntity.ok(articlesService.getArticlesByCategory(categoryID, page, size, sort));
    }

    @GetMapping("/search/{categoryID}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<Page<ArticlesEntity>> searchInCategory(@PathVariable("categoryID") Long categoryID,
                                                                 @RequestParam Integer page,
                                                                 @RequestParam Integer size,
                                                                 @RequestParam String sort,
                                                                 @RequestParam String keySearch) {
        return ResponseEntity.ok(articlesService.searchInCategory(categoryID, page, size, sort, keySearch));
    }

    @GetMapping("/search")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<Page<ArticlesEntity>> search(@RequestParam Integer page,
                                                       @RequestParam Integer size,
                                                       @RequestParam String sort,
                                                       @RequestParam String keySearch) {
        return ResponseEntity.ok(articlesService.search(page, size, sort, keySearch));
    }

    @PostMapping("/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<ArticlesEntity> saveArticles(@RequestBody ArticlesEntity articles) {
        return ResponseEntity.ok(articlesService.save(articles));
    }
}
