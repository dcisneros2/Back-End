package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;


	
@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	
	
	public <S extends User> S save(User user);
	
	
	
	public User findByUsername(String name); 

		
	}
