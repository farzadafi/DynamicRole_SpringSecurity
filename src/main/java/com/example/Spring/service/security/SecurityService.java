package com.example.Spring.service.security;

public interface SecurityService {

    boolean hasPermission(String role,String url);
}
