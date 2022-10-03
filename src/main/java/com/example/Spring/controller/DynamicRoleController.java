package com.example.Spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dynamicRole")
public class DynamicRoleController {

    @GetMapping("/test")
    @PreAuthorize("@SecurityServiceImpel.isAuthenticated(@SecurityServiceImpel.currentUser.getRole().role,#request.requestURI)")
    public String dynamicRoleTest(HttpServletRequest request){
        return "OK";
    }
}
