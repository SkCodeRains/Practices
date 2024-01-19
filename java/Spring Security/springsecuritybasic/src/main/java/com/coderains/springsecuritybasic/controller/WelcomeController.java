package com.coderains.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    private String welcome() {
        return "Welcome to the Spring Security";
    }
}
