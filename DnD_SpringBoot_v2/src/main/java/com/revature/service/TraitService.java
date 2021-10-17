package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Trait;
import com.revature.repositories.TraitRepository;

@Service("traitService")
public class TraitService {
	private TraitRepository traitRepository;
	
	@Autowired
	public TraitService(TraitRepository traitRepository) {

		this.traitRepository = traitRepository;
	}

	public void setTraitRepository(TraitRepository traitRepository) {
		this.traitRepository = traitRepository;
	}
	
	public List<Trait> getAll(int id){
		return this.traitRepository.findAll();
	}
	
	
	public Trait save(Trait trait) {
		return this.traitRepository.save(trait);
	}
	
	public void delete(Trait trait) {
		this.traitRepository.delete(trait);
	}
	
	
	public Trait getById(int id) {
		return this.traitRepository.getById(id);
	}
}
