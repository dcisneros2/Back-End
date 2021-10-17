package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Vitals;
import com.revature.repositories.VitalsRepository;

@Service("vitalsService")
public class VitalsService {
	private VitalsRepository vitalsRepository;
	
	@Autowired
	public VitalsService(VitalsRepository vitalsRepository) {

		this.vitalsRepository = vitalsRepository;
	}

	public void setVitalsRepository(VitalsRepository vitalsRepository) {
		this.vitalsRepository = vitalsRepository;
	}
	
	public List<Vitals> getAll(int id){
		return this.vitalsRepository.findAll();
	}
	
	
	public Vitals save(Vitals vitals) {
		return this.vitalsRepository.save(vitals);
	}
	
	public void delete(Vitals vitals) {
		this.vitalsRepository.delete(vitals);
	}
	
	public Vitals getById(int id) {
		return this.vitalsRepository.getById(id);
	}
}
