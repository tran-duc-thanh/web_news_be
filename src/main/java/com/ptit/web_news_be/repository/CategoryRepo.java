package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.CategorysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategorysEntity, Long> {
}
