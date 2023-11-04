package com.ptit.web_news_be.service;

import com.ptit.web_news_be.entity.ArticlesEntity;

import java.util.List;
import java.util.Optional;

public interface ArticlesService {
    Optional<ArticlesEntity> getOne (Long id);
    List<ArticlesEntity> getArticlesByCategory (Long categoryId);
}
