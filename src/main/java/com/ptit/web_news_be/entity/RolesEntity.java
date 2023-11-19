package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`role`")
@Data
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
