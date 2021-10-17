package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.charactersheet.Action;
import com.revature.repositories.ActionRepository;

@Service("actionService")
public class ActionService {
	private ActionRepository actionRepository;
	
	@Autowired
	public ActionService(ActionRepository actionRepository) {

		this.actionRepository = actionRepository;
	}

	public void setActionRepository(ActionRepository actionRepository) {
		this.actionRepository = actionRepository;
	}
	
	public List<Action> getAll(int id){
		return this.actionRepository.findAll();
	}
	
	
	public Action save(Action action) {
		return this.actionRepository.save(action);
	}
	
	public void delete(Action action) {
		this.actionRepository.delete(action);
	}
	
	public Action findByName(String name) {
		return this.actionRepository.findByName(name);
	}
	
	public Action getById(int id) {
		return this.actionRepository.getById(id);
	}
}
