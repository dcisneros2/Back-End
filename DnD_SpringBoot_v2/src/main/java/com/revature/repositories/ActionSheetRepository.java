package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.ActionSheet;

@Repository("actionSheetRepository")
public interface ActionSheetRepository extends JpaRepository<ActionSheet, Integer>{
	
}
