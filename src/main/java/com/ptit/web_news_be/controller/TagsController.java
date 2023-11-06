package com.ptit.web_news_be.controller;

import com.ptit.web_news_be.dto.MapTagsArticle;
import com.ptit.web_news_be.entity.ArticleTagsEntity;
import com.ptit.web_news_be.entity.TagsEntity;
import com.ptit.web_news_be.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagsController {
    private final TagService tagService;

    public TagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public ResponseEntity<List<TagsEntity>> getAll () {
        return ResponseEntity.ok(tagService.getAll());
    }

    @PostMapping("/save/tagsArticle")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    public void saveTagsForArticle (@RequestBody List<ArticleTagsEntity> mapTagsArticle) {
        tagService.saveTagsForArticle(mapTagsArticle);
    }
}
