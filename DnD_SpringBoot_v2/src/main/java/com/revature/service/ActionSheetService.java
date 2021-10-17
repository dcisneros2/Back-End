package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.ActionSheet;
import com.revature.repositories.ActionSheetRepository;

@Transactional
@Service("ActionSheetService")

public class ActionSheetService {
	private ActionSheetRepository actionSheetRepository;

	@Autowired
	public ActionSheetService(ActionSheetRepository actionSheetRepository) {
		this.actionSheetRepository = actionSheetRepository;
	}

	public void setCharacterSheetRepository(ActionSheetRepository actionSheetRepository) {
		this.actionSheetRepository = actionSheetRepository;
	}

	public ActionSheet getById(int id) {
		return this.actionSheetRepository.getById(id);
	}

	
	public ActionSheet save(ActionSheet actionSheet) {
		return this.actionSheetRepository.save(actionSheet);
	}
}
