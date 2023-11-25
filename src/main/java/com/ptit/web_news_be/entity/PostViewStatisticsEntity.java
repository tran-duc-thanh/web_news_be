package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "postviewstatistics")
@Data
public class PostViewStatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "categoryID")
    private Long categoryID;

    @Column(name = "quantity")
    private Long quantity;
}
