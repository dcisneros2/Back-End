package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.FeatureSheet;
import com.revature.repositories.FeatureSheetRepository;

@Transactional
@Service("FeatureSheetService")

public class FeatureSheetService {
	private FeatureSheetRepository featureSheetRepository;

	@Autowired
	public FeatureSheetService(FeatureSheetRepository featureSheetRepository) {
		this.featureSheetRepository = featureSheetRepository;
	}

	public void setCharacterSheetRepository(FeatureSheetRepository featureSheetRepository) {
		this.featureSheetRepository = featureSheetRepository;
	}

	public FeatureSheet getById(int id) {
		return this.featureSheetRepository.getById(id);
	}

	
	public FeatureSheet save(FeatureSheet featureSheet) {
		return this.featureSheetRepository.save(featureSheet);
	}
}
