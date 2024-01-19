package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalance.ss")
    private String getMyBalance() {
        return "6969";
    }
}
