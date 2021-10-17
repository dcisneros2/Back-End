package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.InventorySheet;
import com.revature.models.charactersheet.SpellSheet;

@Repository("spellSheetRepository")
public interface SpellSheetRepository extends JpaRepository<SpellSheet, Integer>{
	
}
