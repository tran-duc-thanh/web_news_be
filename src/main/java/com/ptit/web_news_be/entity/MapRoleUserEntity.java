package com.ptit.web_news_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`maproleuser`")
@Data
public class MapRoleUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "user_id")
    private Long userId;
}
