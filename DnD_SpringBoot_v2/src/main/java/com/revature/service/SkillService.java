package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Skill;
import com.revature.repositories.SkillRepository;

@Service("skillService")
public class SkillService {
	private SkillRepository skillRepository;
	
	@Autowired
	public SkillService(SkillRepository skillRepository) {

		this.skillRepository = skillRepository;
	}

	public void setSkillRepository(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}
	
	public List<Skill> getAll(int id){
		return this.skillRepository.findAll();
	}
	
	
	public Skill save(Skill skill) {
		return this.skillRepository.save(skill);
	}
	
	public void delete(Skill skill) {
		this.skillRepository.delete(skill);
	}
	
	public Skill findByName(String name) {
		return this.skillRepository.findByName(name);
	}
	
	public Skill getById(int id) {
		return this.skillRepository.getById(id);
	}
}
