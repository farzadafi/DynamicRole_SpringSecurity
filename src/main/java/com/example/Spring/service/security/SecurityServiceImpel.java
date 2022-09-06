package com.example.Spring.service.security;

import com.example.Spring.service.role.RoleServiceImpel;

public class SecurityServiceImpel implements SecurityService {

    private final RoleServiceImpel roleServiceImpel;

    public SecurityServiceImpel(RoleServiceImpel roleServiceImpel) {
        this.roleServiceImpel = roleServiceImpel;
    }

    @Override
    public boolean hasPermission(String role,String url){
        return roleServiceImpel.isPermissionRoleToUrl(role,url);
    }
}
