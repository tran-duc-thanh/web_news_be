package com.ptit.web_news_be.auth.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) throw new UsernameNotFoundException(username);
        return new CustomUserDetail(user.get());
    }

    public UserDetails loadUserById (Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) throw new UsernameNotFoundException(String.valueOf(userId));
        return new CustomUserDetail(user.get());
    }
}
