package com.ptit.web_news_be.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "articles")
public class ArticlesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticleID")
    private Long articleID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "AuthorID")
    private Long authorID;

    @Column(name = "CategoryID")
    private Long categoryID;

    @Column(name = "PublicationDate")
    private Date publicationDate;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Likes")
    private Integer likes;

    @Column(name = "Dislikes")
    private Integer dislikes;

    @Column(name = "ImageBase64")
    private String imageBase64;
}
