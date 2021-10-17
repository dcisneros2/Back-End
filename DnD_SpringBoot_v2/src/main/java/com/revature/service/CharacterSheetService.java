package com.revature.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CharacterSheet;
import com.revature.repositories.CharacterSheetRepository;

@Transactional
@Service("characterSheetService")

public class CharacterSheetService {
	private CharacterSheetRepository characterSheetRepository;

	@Autowired
	public CharacterSheetService(CharacterSheetRepository characterSheetRepository) {
		this.characterSheetRepository = characterSheetRepository;
	}

	public void setCharacterSheetRepository(CharacterSheetRepository characterSheetRepository) {
		this.characterSheetRepository = characterSheetRepository;
	}

	public CharacterSheet save(CharacterSheet characterSheet) {
		return this.characterSheetRepository.save(characterSheet);
	}
	  
}
