package com.ptit.web_news_be.service;

import com.ptit.web_news_be.entity.ArticleTagsEntity;
import com.ptit.web_news_be.entity.TagsEntity;

import java.util.List;

public interface TagService {
    List<TagsEntity> getAll ();
    void saveTagsForArticle (List<ArticleTagsEntity> tags);
    TagsEntity addTag (TagsEntity tag);
}
