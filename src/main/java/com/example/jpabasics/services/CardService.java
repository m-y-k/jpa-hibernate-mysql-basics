package com.example.jpabasics.services;

import com.example.jpabasics.repositories.CardRepository;
import com.example.jpabasics.models.LibraryCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;


    public void addCard(LibraryCard libraryCard) {

        cardRepository.save(libraryCard);
    }
}
