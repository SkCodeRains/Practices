package com.coderains.rainsbank.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Notice;
import com.coderains.rainsbank.repository.NoticeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class NoticesController {

    private NoticeRepository noticeRepository;

    @GetMapping("/notices.ss")
    private ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return null;
        }
    }
}