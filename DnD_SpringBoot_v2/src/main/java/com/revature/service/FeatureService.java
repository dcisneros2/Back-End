package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Feature;
import com.revature.repositories.FeatureRepository;

@Service("featureService")
public class FeatureService {
	private FeatureRepository featureRepository;
	
	@Autowired
	public FeatureService(FeatureRepository featureRepository) {

		this.featureRepository = featureRepository;
	}

	public void setFeatureRepository(FeatureRepository featureRepository) {
		this.featureRepository = featureRepository;
	}
	
	public List<Feature> getAll(int id){
		return this.featureRepository.findAll();
	}
	
	
	public Feature save(Feature feature) {
		return this.featureRepository.save(feature);
	}
	
	public void delete(Feature feature) {
		this.featureRepository.delete(feature);
	}
	
	public Feature findByName(String name) {
		return this.featureRepository.findByName(name);
	}
	
	public Feature getById(int id) {
		return this.featureRepository.getById(id);
	}
}
