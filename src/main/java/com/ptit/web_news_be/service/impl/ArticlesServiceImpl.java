package com.ptit.web_news_be.service.impl;

import com.ptit.web_news_be.auth.user.User;
import com.ptit.web_news_be.auth.user.UserRepository;
import com.ptit.web_news_be.entity.ArticlesEntity;
import com.ptit.web_news_be.entity.PostViewStatisticsEntity;
import com.ptit.web_news_be.repository.ArticlesRepo;
import com.ptit.web_news_be.repository.PostViewStatisticsRepo;
import com.ptit.web_news_be.service.ArticlesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    private final ArticlesRepo articlesRepo;
    private final PostViewStatisticsRepo postViewStatisticsRepo;
    private final UserRepository userRepository;

    public ArticlesServiceImpl(ArticlesRepo articlesRepo, PostViewStatisticsRepo postViewStatisticsRepo, UserRepository userRepository) {
        this.articlesRepo = articlesRepo;
        this.postViewStatisticsRepo = postViewStatisticsRepo;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ArticlesEntity> getOne(Long id, String username) {
        Optional<ArticlesEntity> articles = articlesRepo.findById(id);
        if (username != null) {
            User user = userRepository.findByUsername(username).get();
            Optional<PostViewStatisticsEntity> view = postViewStatisticsRepo.findByUserIdAndCategoryID(user.getId(), articles.get().getCategoryID());
            if (view.isPresent()) {
                view.get().setQuantity(view.get().getQuantity() + 1);
                postViewStatisticsRepo.save(view.get());
            } else {
                PostViewStatisticsEntity v = new PostViewStatisticsEntity();
                v.setQuantity(1L);
                v.setCategoryID(articles.get().getCategoryID());
                v.setUserId(user.getId());
                postViewStatisticsRepo.save(v);
            }
        }
        return articles;
    }

    @Override
    public Page<ArticlesEntity> getArticlesByCategory(Long categoryId, Integer page, Integer size, String sort) {
        Sort s = Sort.by(sort).descending();
        Pageable pageable = PageRequest.of(page, size, s);
        return articlesRepo.findAllByCategoryID(categoryId, pageable);
    }

    @Override
    public Page<ArticlesEntity> searchInCategory(Long categoryId, Integer page, Integer size, String sort, String keySearch) {
        Sort s = Sort.by(sort).descending();
        Pageable pageable = PageRequest.of(page, size, s);
        return articlesRepo.findByCategoryIDAndTitleContaining(categoryId, keySearch, pageable);
    }

    @Override
    public Page<ArticlesEntity> search(Integer page, Integer size, String sort, String keySearch) {
        Sort s = Sort.by(sort).descending();
        Pageable pageable = PageRequest.of(page, size, s);
        return articlesRepo.findByTitleContaining(keySearch, pageable);
    }

    @Override
    public ArticlesEntity save(ArticlesEntity articlesEntity) {
        return articlesRepo.save(articlesEntity);
    }
}
