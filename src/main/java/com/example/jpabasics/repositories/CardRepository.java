package com.example.jpabasics.repositories;

import com.example.jpabasics.models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard, Integer> {

}
