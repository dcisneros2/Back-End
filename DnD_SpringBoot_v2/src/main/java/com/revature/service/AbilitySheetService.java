package com.revature.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.AbilitySheet;
import com.revature.repositories.CharacterSheetRepository;
import com.revature.repositories.AbilitySheetRepository;

@Transactional
@Service("AbilitySheetService")

public class AbilitySheetService {
	private AbilitySheetRepository abilitySheetRepository;

	@Autowired
	public AbilitySheetService(AbilitySheetRepository abilitySheetRepository) {
		this.abilitySheetRepository = abilitySheetRepository;
	}

	public void setCharacterSheetRepository(AbilitySheetRepository abilitySheetRepository) {
		this.abilitySheetRepository = abilitySheetRepository;
	}

	public AbilitySheet getById(int id) {
		return this.abilitySheetRepository.getById(id);
	}

	
	public AbilitySheet save(AbilitySheet abilitySheet) {
		return this.abilitySheetRepository.save(abilitySheet);
	}
}
