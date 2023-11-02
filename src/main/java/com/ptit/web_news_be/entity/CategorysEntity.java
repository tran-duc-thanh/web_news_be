package com.ptit.web_news_be.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategorysEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Long categoryID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private String code;
}
