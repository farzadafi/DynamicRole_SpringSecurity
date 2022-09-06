package com.example.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamicRole")
public class DynamicRoleController {

    @GetMapping("/test")
    public String dynamicRoleTest(){
        return "OK";
    }
}
