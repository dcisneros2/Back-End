package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.BusinessException;
import com.revature.model.User;
import com.revature.service.UserService;

@RestController("userController")

@RequestMapping("user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		
		return new ResponseEntity<List<User>>(this.userService.findAll(), HttpStatus.OK);
	}

	
	@GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByName(@PathVariable String name) {
		return this.userService.findByName(name);
	}

	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRecipe(@RequestBody User user) {
		this.userService.save(user);
	}

	@GetMapping(path = "/exception")
	public void throwException() {
		throw new RuntimeException();
	}
	
	@GetMapping(path = "/exception-handling")
	public void throwBusinessException() {
		throw new BusinessException();
	}


}
