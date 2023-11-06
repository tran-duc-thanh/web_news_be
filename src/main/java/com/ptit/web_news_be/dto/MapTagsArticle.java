package com.ptit.web_news_be.dto;

import com.ptit.web_news_be.entity.ArticleTagsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class MapTagsArticle {
    private List<ArticleTagsEntity> tags;
}
