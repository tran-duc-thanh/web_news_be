package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.ArticleTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTagsRepo extends JpaRepository<ArticleTagsEntity, Long> {
}
