package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tags")
@Data
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TagID")
    private Long tagID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private String code;
}
