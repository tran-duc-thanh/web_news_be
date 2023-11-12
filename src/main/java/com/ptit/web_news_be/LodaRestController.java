package com.ptit.web_news_be;

import com.ptit.web_news_be.auth.jwt.JwtTokenProvider;
import com.ptit.web_news_be.auth.payload.LoginRequest;
import com.ptit.web_news_be.auth.payload.LoginResponse;
import com.ptit.web_news_be.auth.payload.RandomStuff;
import com.ptit.web_news_be.auth.user.CustomUserDetail;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LodaRestController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        String username = userDetail.getUsername();
        return new LoginResponse(jwt, username);
    }

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }
}
