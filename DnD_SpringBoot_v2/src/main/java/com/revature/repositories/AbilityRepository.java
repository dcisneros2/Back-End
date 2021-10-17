package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;

@Repository("abilityRepository")
public interface AbilityRepository extends JpaRepository<Ability, Integer>{

	public Ability findByName(String name);
	
}