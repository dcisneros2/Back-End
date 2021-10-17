package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CharacterDnd;
import com.revature.models.User;
import com.revature.repositories.CharacterDndRepository;

@Transactional
@Service("characterDndService")
public class CharacterDndService {
	private CharacterDndRepository characterDndRepository;

	@Autowired
	public CharacterDndService(CharacterDndRepository characterDndRepository) {
		this.characterDndRepository = characterDndRepository;
	}

	public void setCharacterDndRepository(CharacterDndRepository characterDndRepository) {
		this.characterDndRepository = characterDndRepository;
	}

	public void save(CharacterDnd characterDnd) {
		this.characterDndRepository.save(characterDnd);
	}

	public CharacterDnd getById(int id) {
		return this.characterDndRepository.getById(id);
	}
	
	public List<CharacterDnd> findAll() {
		return this.characterDndRepository.findAll(); 
	}

	public CharacterDnd findByName(String name) {
		return this.characterDndRepository.findByName(name);
		
	}
	
	
	  
	 
}
