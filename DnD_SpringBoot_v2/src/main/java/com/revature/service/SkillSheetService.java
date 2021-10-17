package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.SkillSheet;
import com.revature.repositories.SkillSheetRepository;

@Transactional
@Service("SkillSheetService")

public class SkillSheetService {
	private SkillSheetRepository skillSheetRepository;

	@Autowired
	public SkillSheetService(SkillSheetRepository skillSheetRepository) {
		this.skillSheetRepository = skillSheetRepository;
	}

	public void setCharacterSheetRepository(SkillSheetRepository skillSheetRepository) {
		this.skillSheetRepository = skillSheetRepository;
	}

	public SkillSheet getById(int id) {
		return this.skillSheetRepository.getById(id);
	}

	
	public SkillSheet save(SkillSheet skillSheet) {
		return this.skillSheetRepository.save(skillSheet);
	}
}
