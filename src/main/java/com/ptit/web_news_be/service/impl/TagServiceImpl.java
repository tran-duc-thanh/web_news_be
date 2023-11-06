package com.ptit.web_news_be.service.impl;

import com.ptit.web_news_be.entity.ArticleTagsEntity;
import com.ptit.web_news_be.entity.TagsEntity;
import com.ptit.web_news_be.repository.ArticleTagsRepo;
import com.ptit.web_news_be.repository.TagsRepo;
import com.ptit.web_news_be.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagsRepo tagsRepo;
    private final ArticleTagsRepo articleTagsRepo;

    public TagServiceImpl(TagsRepo tagsRepo, ArticleTagsRepo articleTagsRepo) {
        this.tagsRepo = tagsRepo;
        this.articleTagsRepo = articleTagsRepo;
    }

    @Override
    public List<TagsEntity> getAll() {
        return tagsRepo.findAll();
    }

    @Override
    public void saveTagsForArticle(List<ArticleTagsEntity> tags) {
        articleTagsRepo.saveAll(tags);
    }
}
