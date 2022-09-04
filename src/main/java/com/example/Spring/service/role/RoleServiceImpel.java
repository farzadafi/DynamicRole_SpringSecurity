package com.example.Spring.service.role;

import com.example.Spring.reposiroty.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpel implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public boolean isPermissionRoleToUrl(String role, String url){
        return roleRepository.findRoleWithUrl(role, url).isPresent();
    }
}
