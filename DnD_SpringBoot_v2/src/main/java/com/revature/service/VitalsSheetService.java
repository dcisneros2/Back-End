package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.VitalsSheet;
import com.revature.repositories.VitalsSheetRepository;

@Transactional
@Service("VitalsSheetService")

public class VitalsSheetService {
	private VitalsSheetRepository vitalsSheetRepository;

	@Autowired
	public VitalsSheetService(VitalsSheetRepository vitalsSheetRepository) {
		this.vitalsSheetRepository = vitalsSheetRepository;
	}

	public void setCharacterSheetRepository(VitalsSheetRepository vitalsSheetRepository) {
		this.vitalsSheetRepository = vitalsSheetRepository;
	}

	public VitalsSheet getById(int id) {
		return this.vitalsSheetRepository.getById(id);
	}

	
	public VitalsSheet save(VitalsSheet vitalsSheet) {
		return this.vitalsSheetRepository.save(vitalsSheet);
	}
}
