package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Ability;
import com.revature.repositories.AbilityRepository;

@Service("abilityService")
public class AbilityService {
	private AbilityRepository abilityRepository;
	
	@Autowired
	public AbilityService(AbilityRepository abilityRepository) {

		this.abilityRepository = abilityRepository;
	}

	public void setAbilityRepository(AbilityRepository abilityRepository) {
		this.abilityRepository = abilityRepository;
	}
	
	public List<Ability> getAll(int id){
		return this.abilityRepository.findAll();
	}
	
	
	public Ability save(Ability ability) {
		return this.abilityRepository.save(ability);
	}
	
	public void delete(Ability ability) {
		this.abilityRepository.delete(ability);
	}
	
	public Ability findByName(String name) {
		return this.abilityRepository.findByName(name);
	}
	
	public Ability getById(int id) {
		return this.abilityRepository.getById(id);
	}
}
