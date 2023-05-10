package com.example.jpabasics.controllers;

import com.example.jpabasics.services.CardService;
import com.example.jpabasics.models.LibraryCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    // API - 1 ---> add a card
    @PostMapping("/add")
    public String addCard(@RequestBody LibraryCard libraryCard) {

        cardService.addCard(libraryCard);

        return "Card added successfully";
    }

}
