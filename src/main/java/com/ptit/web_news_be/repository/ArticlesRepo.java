package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepo extends JpaRepository<ArticlesEntity, Long> {
}
