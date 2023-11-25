package com.ptit.web_news_be.repository;

import com.ptit.web_news_be.entity.PostViewStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostViewStatisticsRepo extends JpaRepository<PostViewStatisticsEntity, Long> {
    Optional<PostViewStatisticsEntity> findByUserIdAndCategoryID(Long uId, Long cId);
    List<PostViewStatisticsEntity> findAllByUserId (Long uId);
}
