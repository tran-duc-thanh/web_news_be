package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<TagsEntity, Long> {
}
