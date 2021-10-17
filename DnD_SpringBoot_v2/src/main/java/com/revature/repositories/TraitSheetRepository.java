package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.TraitSheet;

@Repository("traitSheetRepository")
public interface TraitSheetRepository extends JpaRepository<TraitSheet, Integer>{
	
}
