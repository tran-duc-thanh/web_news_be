package com.ptit.web_news_be.auth.payload;

import com.ptit.web_news_be.entity.RolesEntity;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private List<RolesEntity> roles;

    public LoginResponse(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }
}
