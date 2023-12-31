package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "articles")
@Data
public class ArticlesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticleID")
    private Long articleID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "SubContent")
    private String subContent;

    @Column(name = "AuthorID")
    private Long authorID;

    @Column(name = "CategoryID")
    private Long categoryID;

    @Column(name = "PublicationDate")
    private String publicationDate;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Likes")
    private Integer likes;

    @Column(name = "Dislikes")
    private Integer dislikes;

    @Lob
    @Column(name = "ImageBase64", columnDefinition = "LONGTEXT")
    private String imageBase64;
}
