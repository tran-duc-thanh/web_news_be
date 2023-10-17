package com.ptit.web_news_be.auth.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`user`")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}
