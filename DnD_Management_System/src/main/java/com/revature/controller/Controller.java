package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.repositories.UserRepository;

@RestController("Controller")

@RequestMapping("/index")
public class Controller {

	private UserService userService;

	//@Autowired
	//UserRepository userRepository;
	
	@Autowired
	public Controller(UserService userService) {
		this.userService = userService;
	}
	//TODO: Return message if account is made or not. Add Json return to GetMapping.
	@GetMapping("/createUser")
	public void createUser(@RequestParam Map<String, String> queryParams) {
		User user = new User(
				queryParams.get("username"), 
				queryParams.get("password"),
				queryParams.get("accountType"),
				null);
		this.userService.save(user);
	}
	
	//@GetMapping("/getUser/{id}")
	//public User getUserById() {
	//	return null;
		
	//}
	
	@GetMapping("/getUser/{username}")
	public User getUserByUsername(@RequestParam String username) {
		System.out.println(username);
		//return this.userService.findByUsername(username);
		return null;
	}

	
	
	/*
	 * @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<User>> findAll() {
	 * 
	 * return new ResponseEntity<List<User>>(this.userService.findAll(),
	 * HttpStatus.OK); }
	 * 
	 * 
	 * @GetMapping(path = "/name/{name}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public User findByName(@PathVariable String
	 * name) { return this.userService.findByName(name); }
	 * 
	 * @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public void saveRecipe(@RequestBody User user) { this.userService.save(user);
	 * }
	 * 
	 * @GetMapping(path = "/exception") public void throwException() { throw new
	 * RuntimeException(); }
	 * 
	 * @GetMapping(path = "/exception-handling") public void
	 * throwBusinessException() { throw new BusinessException(); }
	 */
}
