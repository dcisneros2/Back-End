package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.service.CharacterDndService;

@RestController("CharacterDndController")
@RequestMapping("/character")
public class CharacterDndController {
	private CharacterDndService characterDndService;
	
	@Autowired
	public CharacterDndController(CharacterDndService characterDndService) {
		this.characterDndService = characterDndService;
	}
	
	//TODO: Return message if characterDnd is made or not. Add Json return to GetMapping.
	@PostMapping(path = "/createCharacterDnd", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCharacterDnd(@RequestBody CharacterDnd characterDnd) {
/*		CharacterDnd characterDnd = new CharacterDnd(
				queryParams.get("name"),
				Integer.valueOf(queryParams.get("playerCount"))
				);*/
		this.characterDndService.save(characterDnd);
	}
	
}
