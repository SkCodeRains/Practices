package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contact.ss")
    private String getContactDetails() {
        return "6969";
    }
}
