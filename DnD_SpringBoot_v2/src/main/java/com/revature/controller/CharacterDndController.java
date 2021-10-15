package com.revature.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Campaign;
import com.revature.models.CharacterDnd;
import com.revature.models.User;
import com.revature.service.CampaignService;
import com.revature.service.CharacterDndService;
import com.revature.service.UserService;

@RestController("CharacterDndController")
@RequestMapping("/character")
public class CharacterDndController {
	private CharacterDndService characterDndService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CampaignService campaignService;

	@Autowired
	public CharacterDndController(CharacterDndService characterDndService) {
		this.characterDndService = characterDndService;
	}

	// TODO: Return message if characterDnd is made or not. Add Json return to
	@PostMapping(path = "/createCharacter")
	public void createCharacterDnd(@RequestParam String name, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		
		if (session != null) {
			session.setAttribute("characterName", name);
			CharacterDnd characterDnd = new CharacterDnd(name);

			User user = userService.findById((Integer)session.getAttribute("userId"));
			if (user != null) {
				
			
				Campaign campaign = campaignService.getById((Integer) session.getAttribute("currentCampaignId"));
				if (campaign != null) {
					campaign.getCharacters().add(characterDnd);
					characterDnd.setUser(user);
					characterDnd.setCampaign(campaign);
					this.characterDndService.save(characterDnd);
				}
				else {
					//TODO: No campaign selected
				}
			}
			else {
				//TODO: User not logged in message
			}
			

		}

	}

	@PostMapping(path = "/selectCharacter")
	public void selectCharacterDnd(@RequestParam String name, HttpServletRequest request) {
		CharacterDnd characterDnd = characterDndService.findByName(name);
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			if (characterDnd != null) {
				session.setAttribute("characterId", characterDnd.getCharacterId());
				//this.characterDndService.save(characterDnd);
			} else {
				// TODO: Character does not exist message
				System.out.println("Character does not exist");
			}
		}
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterDnd>> getAll() {
		return new ResponseEntity<List<CharacterDnd>>(this.characterDndService.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/getAllByUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllByUser(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null) {
			User user = userService.findById((Integer) session.getAttribute("userId"));
			if(user != null) {
				List<String> names = new ArrayList<>();
				
				
				for(int x=0; x< user.getCharacters().size(); x++) {
					names.add("name: " + user.getCharacters().get(x).getName() + "," + "campaign: " + user.getCharacters().get(x).getCampaign().getName());
					
				}
				return names;
			}
			else {
				//TODO: User has no characters
			}
		}
			return null;		
	}
	
	@GetMapping(path = "/getCharacter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterDnd> getCharacterByName(@RequestParam String name) {
		return new ResponseEntity<CharacterDnd>(this.characterDndService.findByName(name), HttpStatus.OK);
	}
}
