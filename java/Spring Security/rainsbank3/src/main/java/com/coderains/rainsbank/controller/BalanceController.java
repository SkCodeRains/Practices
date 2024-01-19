package com.coderains.rainsbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.AccountTransactions;
import com.coderains.rainsbank.repository.AccountTransactionsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BalanceController {
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance.ss")
    private List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository
                .findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
