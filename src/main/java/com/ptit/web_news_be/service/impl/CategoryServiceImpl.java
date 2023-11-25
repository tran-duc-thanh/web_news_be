package com.ptit.web_news_be.service.impl;

import com.ptit.web_news_be.auth.user.User;
import com.ptit.web_news_be.auth.user.UserRepository;
import com.ptit.web_news_be.entity.CategorysEntity;
import com.ptit.web_news_be.entity.PostViewStatisticsEntity;
import com.ptit.web_news_be.repository.CategoryRepo;
import com.ptit.web_news_be.repository.PostViewStatisticsRepo;
import com.ptit.web_news_be.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final UserRepository userRepository;
    private final PostViewStatisticsRepo postViewStatisticsRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo, UserRepository userRepository, PostViewStatisticsRepo postViewStatisticsRepo) {
        this.categoryRepo = categoryRepo;
        this.userRepository = userRepository;
        this.postViewStatisticsRepo = postViewStatisticsRepo;
    }

    @Override
    public List<CategorysEntity> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public List<CategorysEntity> getFavoriteGenre(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            List<PostViewStatisticsEntity> postViewStatisticsEntities = postViewStatisticsRepo.findAllByUserId(user.get().getId());
            postViewStatisticsEntities.sort(Comparator.comparingLong(PostViewStatisticsEntity::getQuantity).reversed());
            List<CategorysEntity> categories = new ArrayList<>();
            postViewStatisticsEntities.forEach(item -> {
                Optional<CategorysEntity> optional = categoryRepo.findById(item.getCategoryID());
                if (optional.isPresent()) {
                    categories.add(optional.get());
                }
            });
            return categories;
        }
        return null;
    }

    @Override
    public CategorysEntity addCategory(CategorysEntity category) {
        return categoryRepo.save(category);
    }

    @Override
    public CategorysEntity getOne(Long id) {
        return categoryRepo.findById(id).get();
    }
}
