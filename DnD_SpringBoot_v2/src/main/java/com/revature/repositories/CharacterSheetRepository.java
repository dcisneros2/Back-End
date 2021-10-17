package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.CharacterSheet;

@Repository("characterSheetRepository")
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Integer> {

}
