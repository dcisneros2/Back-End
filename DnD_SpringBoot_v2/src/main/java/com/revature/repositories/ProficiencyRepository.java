package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;
import com.revature.models.charactersheet.Proficiency;

@Repository("proficiencyRepository")
public interface ProficiencyRepository extends JpaRepository<Proficiency, Integer>{

	public Proficiency findByName(String name);
	
}