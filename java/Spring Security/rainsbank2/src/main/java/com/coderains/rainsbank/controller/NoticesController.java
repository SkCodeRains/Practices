package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/notices.ss")
    private String getNotices() {
        return "6969";
    }
}
