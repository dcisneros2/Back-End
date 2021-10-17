package com.revature.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.ProficiencySheet;
import com.revature.repositories.CharacterSheetRepository;
import com.revature.repositories.ProficiencySheetRepository;

@Transactional
@Service("ProficiencySheetService")

public class ProficiencySheetService {
	private ProficiencySheetRepository proficiencySheetRepository;

	@Autowired
	public ProficiencySheetService(ProficiencySheetRepository proficiencySheetRepository) {
		this.proficiencySheetRepository = proficiencySheetRepository;
	}

	public void setCharacterSheetRepository(ProficiencySheetRepository proficiencySheetRepository) {
		this.proficiencySheetRepository = proficiencySheetRepository;
	}

	public ProficiencySheet getById(int id) {
		return this.proficiencySheetRepository.getById(id);
	}

	
	public ProficiencySheet save(ProficiencySheet proficiencySheet) {
		return this.proficiencySheetRepository.save(proficiencySheet);
	}
}
