package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.Skill;

@Repository("skillRepository")
public interface SkillRepository extends JpaRepository<Skill, Integer>{

	public Skill findByName(String name);
	
}