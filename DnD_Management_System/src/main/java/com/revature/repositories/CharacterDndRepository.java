package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.CharacterDnd;
import com.revature.models.User;

public interface CharacterDndRepository extends JpaRepository<CharacterDnd, Integer>{
	public CharacterDnd findByName(String name);
}
