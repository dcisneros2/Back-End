package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.revature.models.Campaign;
import com.revature.models.CharacterDnd;
import com.revature.service.CampaignService;
import com.revature.service.CharacterDndService;
import com.revature.service.UserService;

@RestController("CharacterDndController")
@RequestMapping("/character")
public class CharacterDndController {
	private CharacterDndService characterDndService;
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	public CharacterDndController(CharacterDndService characterDndService) {
		this.characterDndService = characterDndService;
	}
	
	//TODO: Return message if characterDnd is made or not. Add Json return to GetMapping.
	@PostMapping(path = "/createCharacter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCharacterDnd(@RequestParam String name, HttpServletRequest session) {
		CharacterDnd characterDnd = new CharacterDnd(
				name
				);
		Campaign campaign = campaignService.getById((Integer)session.getAttribute("currentCampaignId"));
		characterDnd.setCampaign(campaign);
		this.characterDndService.save(characterDnd);
	}
	
	@GetMapping(path = "/selectCharacter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void selectCharacterDnd(@RequestParam String name, HttpServletRequest session) {
		CharacterDnd characterDnd = characterDndService.findByName(name);
		if(characterDnd != null) {
			session.setAttribute("characterId", characterDnd.getCharacterId());
			this.characterDndService.save(characterDnd);
		}
		else {
			//TODO: Character does not exist message
			System.out.println("Character does not exist");
		}
		
	}
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterDnd>> getAll() {
		return new ResponseEntity<List<CharacterDnd>>(this.characterDndService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/getCharacter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterDnd> getCharacterByName(@RequestParam String name) {
		return new ResponseEntity<CharacterDnd>(this.characterDndService.findByName(name), HttpStatus.OK);
	}
}
