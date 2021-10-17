package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.MoneySheet;
import com.revature.repositories.MoneySheetRepository;

@Transactional
@Service("MoneySheetService")

public class MoneySheetService {
	private MoneySheetRepository moneySheetRepository;

	@Autowired
	public MoneySheetService(MoneySheetRepository moneySheetRepository) {
		this.moneySheetRepository = moneySheetRepository;
	}

	public void setCharacterSheetRepository(MoneySheetRepository moneySheetRepository) {
		this.moneySheetRepository = moneySheetRepository;
	}

	public MoneySheet getById(int id) {
		return this.moneySheetRepository.getById(id);
	}

	
	public MoneySheet save(MoneySheet moneySheet) {
		return this.moneySheetRepository.save(moneySheet);
	}
}
