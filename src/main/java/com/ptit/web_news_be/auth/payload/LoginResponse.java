package com.ptit.web_news_be.auth.payload;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;

    public LoginResponse(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }
}
