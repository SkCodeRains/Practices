package com.coderains.rainsbank.controller;

import java.util.Date;
import java.util.Random;
 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Contact;
import com.coderains.rainsbank.repository.ContactRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ContactController {

    private ContactRepository contactRepository;

    @PostMapping("/contact.ss")
    private Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
