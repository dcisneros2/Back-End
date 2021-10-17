package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.models.charactersheet.Spell;
import com.revature.repositories.SpellRepository;

@Service("spellService")
public class SpellService {
	private SpellRepository spellRepository;
	
	@Autowired
	public SpellService(SpellRepository spellRepository) {

		this.spellRepository = spellRepository;
	}

	public void setSpellRepository(SpellRepository spellRepository) {
		this.spellRepository = spellRepository;
	}
	
	public List<Spell> getAll(int id){
		return this.spellRepository.findAll();
	}
	
	
	public Spell save(Spell spell) {
		return this.spellRepository.save(spell);
	}
	
	public void delete(Spell spell) {
		this.spellRepository.delete(spell);
	}
	
	public Spell findByName(String name) {
		return this.spellRepository.findByName(name);
	}
	
	public Spell getById(int id) {
		return this.spellRepository.getById(id);
	}
}
