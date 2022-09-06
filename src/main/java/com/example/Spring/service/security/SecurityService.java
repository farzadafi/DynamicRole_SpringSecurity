package com.example.Spring.service.security;

import com.example.Spring.model.User;

public interface SecurityService {

    boolean hasPermission(String role,String url);
    User getCurrentUser();
}
