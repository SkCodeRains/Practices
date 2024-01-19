package com.coderains.rainsbank.controller;

import java.util.List;
 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Loans;
import com.coderains.rainsbank.repository.LoanRepository;

@RestController
public class LoanController {

    private LoanRepository loanRepository;

    @PostMapping("/myLoans.ss")
    private List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }
}
