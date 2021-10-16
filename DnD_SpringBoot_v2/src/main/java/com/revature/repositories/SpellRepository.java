package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Item;
import com.revature.models.charactersheet.Spell;

@Repository("spellRepository")
public interface SpellRepository extends JpaRepository<Spell, Integer>{

	public Spell findByName(String name);
	
}