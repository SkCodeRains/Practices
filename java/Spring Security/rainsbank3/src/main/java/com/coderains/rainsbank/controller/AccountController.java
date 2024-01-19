package com.coderains.rainsbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Accounts;
import com.coderains.rainsbank.repository.AccountsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {

    AccountsRepository accountsRepository;

    @GetMapping("/myAccount.ss")
    private Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

}
