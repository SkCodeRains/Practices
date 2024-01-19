package com.coderains.rainsbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Loans;
import com.coderains.rainsbank.repository.LoanRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {

    private LoanRepository loanRepository;

    @GetMapping("/myLoans.ss")
    private List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }
}
