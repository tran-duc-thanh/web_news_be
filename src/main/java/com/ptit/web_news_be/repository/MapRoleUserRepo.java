package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.MapRoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapRoleUserRepo extends JpaRepository<MapRoleUserEntity, Long> {
    List<MapRoleUserEntity> findAllByUserId (Long userId);
}
