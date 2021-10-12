package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service("userService")
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(User user) {
		this.userRepository.save(user);
	}
	
	/*
	 * public User findByUsername(String username) { return
	 * this.userRepository.findByUserusername(username); }
	 */

	/*
	 * public User findById(int id) { return this.userRepository.getById(id);
	 * 
	 * }
	 */

	/*
	 * public List<User> findAll(){ return this.userRepository.findAll(); }
	 * 
	 * public void save(User user) { this.userRepository.save(user); }
	 * 

	 */
}
