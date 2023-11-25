package com.ptit.web_news_be.service;

import com.ptit.web_news_be.entity.ArticlesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ArticlesService {
    Optional<ArticlesEntity> getOne (Long id, String username);
    Page<ArticlesEntity> getArticlesByCategory (Long categoryId, Integer page, Integer size, String sort);
    Page<ArticlesEntity> searchInCategory (Long categoryId, Integer page, Integer size, String sort, String keySearch);
    Page<ArticlesEntity> search (Integer page, Integer size, String sort, String keySearch);
    ArticlesEntity save (ArticlesEntity articlesEntity);
}
