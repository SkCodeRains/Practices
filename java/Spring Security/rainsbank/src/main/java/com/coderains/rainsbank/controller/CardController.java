package com.coderains.rainsbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Cards;
import com.coderains.rainsbank.repository.CardsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CardController {

    private CardsRepository cardsRepository;

    @GetMapping("/myCards.ss")
    private List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
