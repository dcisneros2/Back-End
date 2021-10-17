package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Proficiency;
import com.revature.repositories.ProficiencyRepository;

@Service("proficiencyService")
public class ProficiencyService {
	private ProficiencyRepository proficiencyRepository;
	
	@Autowired
	public ProficiencyService(ProficiencyRepository proficiencyRepository) {

		this.proficiencyRepository = proficiencyRepository;
	}

	public void setProficiencyRepository(ProficiencyRepository proficiencyRepository) {
		this.proficiencyRepository = proficiencyRepository;
	}
	
	public List<Proficiency> getAll(int id){
		return this.proficiencyRepository.findAll();
	}
	
	
	public Proficiency save(Proficiency proficiency) {
		return this.proficiencyRepository.save(proficiency);
	}
	
	public void delete(Proficiency proficiency) {
		this.proficiencyRepository.delete(proficiency);
	}
	
	public Proficiency findByName(String name) {
		return this.proficiencyRepository.findByName(name);
	}
	
	public Proficiency getById(int id) {
		return this.proficiencyRepository.getById(id);
	}
}
