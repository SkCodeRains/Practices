package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/myCards.ss")
    private String getCardsDetails() {
        return "6969";
    }
}
