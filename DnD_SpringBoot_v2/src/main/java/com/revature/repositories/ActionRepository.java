package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;
import com.revature.models.charactersheet.Action;

@Repository("actionRepository")
public interface ActionRepository extends JpaRepository<Action, Integer>{

	public Action findByName(String name);
	
}