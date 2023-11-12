package com.ptit.web_news_be.service.impl;

import com.ptit.web_news_be.entity.CategorysEntity;
import com.ptit.web_news_be.repository.CategoryRepo;
import com.ptit.web_news_be.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategorysEntity> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public CategorysEntity addCategory(CategorysEntity category) {
        return categoryRepo.save(category);
    }

    @Override
    public CategorysEntity getOne(Long id) {
        return categoryRepo.findById(id).get();
    }
}
