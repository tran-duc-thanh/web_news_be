package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RolesEntity, Long> {
}
