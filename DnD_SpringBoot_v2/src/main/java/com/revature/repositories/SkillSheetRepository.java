package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.SkillSheet;

@Repository("skillSheetRepository")
public interface SkillSheetRepository extends JpaRepository<SkillSheet, Integer>{
	
}
