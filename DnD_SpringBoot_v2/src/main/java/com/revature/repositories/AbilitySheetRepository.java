package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.AbilitySheet;

@Repository("abilitySheetRepository")
public interface AbilitySheetRepository extends JpaRepository<AbilitySheet, Integer>{
	
}
