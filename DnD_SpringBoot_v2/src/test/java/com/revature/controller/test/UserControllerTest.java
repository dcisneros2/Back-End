package com.revature.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.controller.UserController;
import com.revature.models.Campaign;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.service.UserService;

@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)

public class UserControllerTest {
	
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController  userController;
	
	@Mock
	private UserRepository userRepository;
	
	
	private User newuser;

	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	newuser = new User();
		MockitoAnnotations.openMocks(this);
			
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void testCreateUser () {
		
	when(userRepository.save(Mockito.any(User.class))).thenReturn(newuser);
	User returnuser = new User("name", "pass", "type");
	assertEquals(returnuser, newuser);
	 verify(userRepository, times(1)).save(Mockito.any(User.class));
	 
	 
	 
		try {
			mockMvc.perform(get("/createUser")).andExpect(status().isOk()).andExpect(content()
					.contentType(MediaType.APPLICATION_JSON)).andDo( print()).andReturn();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUsers () {
		
		newuser.setUsername("user");
		when(userService.findByUsername(newuser.getUsername())).thenReturn(newuser);
		
		User returnuser  = new User();
		returnuser.setUsername("user");
		assertEquals(returnuser.getUsername(), newuser);
	}
	
	@Test
	public void testGetSignIn() {
		newuser.setUsername("user");
		newuser.setPassword("pass");
		when(userService.findByUsernameAndPassword(newuser.getUsername(), newuser.getPassword())).thenReturn(newuser);
		
		User returnuser  = new User();
		returnuser.setUsername("user");
		returnuser.setPassword("pass");
		
		assertEquals(returnuser, newuser);
		
		assertEquals("user", newuser);
	}
	
}
