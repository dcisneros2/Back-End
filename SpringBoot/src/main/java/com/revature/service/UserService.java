package com.revature.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;


@Service("userService")
public class UserService {
	
	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public void setRecipeRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public User findByName(String name) {
		return this.userRepository.findByUsername(name);
	}
}
