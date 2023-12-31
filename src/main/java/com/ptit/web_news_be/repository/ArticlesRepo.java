package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.ArticlesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepo extends JpaRepository<ArticlesEntity, Long> {
    Page<ArticlesEntity> findAllByCategoryID (Long categoryId, Pageable pageable);
    Page<ArticlesEntity> findByTitleContaining (String keyword, Pageable pageable);
    Page<ArticlesEntity> findByCategoryIDAndTitleContaining (Long categoryId, String keyword, Pageable pageable);
}
