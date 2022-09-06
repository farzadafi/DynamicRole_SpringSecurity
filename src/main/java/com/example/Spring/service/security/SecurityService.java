package com.example.Spring.service.security;

import com.example.Spring.model.User;

public interface SecurityService {

    boolean isAuthenticated(String role,String url);
    User getCurrentUser();
}
