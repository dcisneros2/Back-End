package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;
import com.revature.models.charactersheet.Feature;

@Repository("featureRepository")
public interface FeatureRepository extends JpaRepository<Feature, Integer>{

	public Feature findByName(String name);
	
}