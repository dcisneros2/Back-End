package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.Vitals;
import com.revature.models.charactersheet.VitalsSheet;

@Repository("vitalsSheetRepository")
public interface VitalsSheetRepository extends JpaRepository<VitalsSheet, Integer>{
	
}
