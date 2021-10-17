package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;
import com.revature.models.charactersheet.Vitals;
import com.revature.models.charactersheet.VitalsSheet;

@Repository("vitalsRepository")
public interface VitalsRepository extends JpaRepository<Vitals, Integer>{

	public Vitals findByClazz(String clazz);
	
}