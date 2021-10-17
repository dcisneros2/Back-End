package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Money;
import com.revature.repositories.MoneyRepository;

@Service("moneyService")
public class MoneyService {
	private MoneyRepository moneyRepository;
	
	@Autowired
	public MoneyService(MoneyRepository moneyRepository) {

		this.moneyRepository = moneyRepository;
	}

	public void setMoneyRepository(MoneyRepository moneyRepository) {
		this.moneyRepository = moneyRepository;
	}
	
	public List<Money> getAll(int id){
		return this.moneyRepository.findAll();
	}
	
	
	public Money save(Money money) {
		return this.moneyRepository.save(money);
	}
	
	public void delete(Money money) {
		this.moneyRepository.delete(money);
	}
	
	public Money findByName(String name) {
		return this.moneyRepository.findByName(name);
	}
	
	public Money getById(int id) {
		return this.moneyRepository.getById(id);
	}
}
