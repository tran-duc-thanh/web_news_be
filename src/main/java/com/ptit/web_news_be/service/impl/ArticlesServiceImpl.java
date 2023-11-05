package com.ptit.web_news_be.service.impl;

import com.ptit.web_news_be.entity.ArticlesEntity;
import com.ptit.web_news_be.repository.ArticlesRepo;
import com.ptit.web_news_be.service.ArticlesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    private final ArticlesRepo articlesRepo;

    public ArticlesServiceImpl(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }

    @Override
    public Optional<ArticlesEntity> getOne(Long id) {
        return articlesRepo.findById(id);
    }

    @Override
    public Page<ArticlesEntity> getArticlesByCategory(Long categoryId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return articlesRepo.findAllByCategoryID(categoryId, pageable);
    }

    @Override
    public ArticlesEntity save(ArticlesEntity articlesEntity) {
        return articlesRepo.save(articlesEntity);
    }
}
