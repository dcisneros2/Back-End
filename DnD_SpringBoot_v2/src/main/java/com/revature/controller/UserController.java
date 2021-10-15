package com.revature.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
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
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	//TODO: Return message if account is made or not. Add Json return to GetMapping.
	@GetMapping("/createUser")
	public void createUser(@RequestParam Map<String, String> queryParams) {
		User user = new User(
				queryParams.get("username"), 
				queryParams.get("password"),
				queryParams.get("accountType")
				);
		this.userService.save(user);
	}
	
	@GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestParam String username) {
		return this.userService.findByUsername(username);
	}

	
	@PostMapping(path = "/signIn")
	public ResponseEntity<String>signIn (@RequestParam Map<String, String> queryParams, HttpServletRequest request) {
		User user = this.userService.findByUsernameAndPassword(
				queryParams.get("username"),
				queryParams.get("password"));
		
		if(user == null) {
			//TODO: Return message that user is not found.
			return new ResponseEntity<String>("Incorrect user or password", HttpStatus.BAD_REQUEST);	
		}
		else { 
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getPlayerId());
			session.setAttribute("user", user);
			System.out.println((Integer)session.getAttribute("userId"));
			return new ResponseEntity<String>("Signed in", HttpStatus.OK);			
		}
	}
	
	@GetMapping(path = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>signOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			return new ResponseEntity<String>("Logged out",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Already signed out", HttpStatus.BAD_REQUEST);	
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
