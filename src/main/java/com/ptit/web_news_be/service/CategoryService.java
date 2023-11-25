package com.ptit.web_news_be.service;

import com.ptit.web_news_be.entity.CategorysEntity;

import java.util.List;

public interface CategoryService {
    List<CategorysEntity> getAll ();
    List<CategorysEntity> getFavoriteGenre (String username);
    CategorysEntity addCategory (CategorysEntity category);
    CategorysEntity getOne (Long id);
}
