package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.CharacterSheet;

public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Integer> {

}
