package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.FeatureSheet;

@Repository("featureSheetRepository")
public interface FeatureSheetRepository extends JpaRepository<FeatureSheet, Integer>{
	
}
