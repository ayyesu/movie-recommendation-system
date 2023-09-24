package com.recommendation.system.api.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
