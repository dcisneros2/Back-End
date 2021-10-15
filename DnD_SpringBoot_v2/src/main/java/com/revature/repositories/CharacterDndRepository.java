package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.CharacterDnd;
import com.revature.models.User;

@Repository("characterDndRepository")
public interface CharacterDndRepository extends JpaRepository<CharacterDnd, Integer>{
	public CharacterDnd findByName(String name);

}
