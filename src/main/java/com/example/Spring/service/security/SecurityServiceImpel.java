package com.example.Spring.service.security;

import com.example.Spring.model.User;
import com.example.Spring.service.role.RoleServiceImpel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("SecurityServiceImpel")
public class SecurityServiceImpel implements SecurityService {

    private final RoleServiceImpel roleServiceImpel;

    public SecurityServiceImpel(RoleServiceImpel roleServiceImpel) {
        this.roleServiceImpel = roleServiceImpel;
    }

    @Override
    public boolean hasPermission(String role,String url){
        return roleServiceImpel.isPermissionRoleToUrl(role,url);
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
