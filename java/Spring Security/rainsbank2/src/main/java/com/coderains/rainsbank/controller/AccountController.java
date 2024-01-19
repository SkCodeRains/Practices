package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount.ss")
    private String getAccountDetails() {
        return "Hey There Welcome to Rains World Bank";
    }

}
