package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "articletags")
@Data
public class ArticleTagsEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ArticleID")
    private Long articleID;

    @Column(name = "TagID")
    private Long tagID;
}
