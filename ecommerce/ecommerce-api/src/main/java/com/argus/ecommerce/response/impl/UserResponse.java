package com.argus.ecommerce.response.impl;

import java.time.LocalDateTime;

public class UserResponse {
    private String username;
    private String email;
    private LocalDateTime creationTime;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreationTime() {
        return this.creationTime.toString();
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}