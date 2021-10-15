package com.revature.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.CharacterSheet;
import com.revature.models.InventorySheet;
import com.revature.models.SpellSheet;
import com.revature.service.CharacterDndService;
import com.revature.service.CharacterSheetService;
@RestController("CharacterSheetController")

@RequestMapping("/character/sheet")
public class CharacterSheetController {
	
	@Autowired
	private CharacterDndService characterDndService;
	
	private CharacterSheetService characterSheetService;
	
	
	@Autowired
	public CharacterSheetController(CharacterSheetService characterSheetService) {
		this.characterSheetService = characterSheetService;
		}

	@PostMapping(path = "/create",  produces = MediaType.APPLICATION_JSON_VALUE)
	public CharacterSheet createCharacterSheet(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if (character.getCharacterSheet() == null) {
				CharacterSheet characterSheet = new CharacterSheet();
				//InventorySheet inventorySheet = new InventorySheet();
				
				session.setAttribute("characterSheetId", characterSheet.getCharacterSheetId());
				character.setCharacterSheet(characterSheet);
				
				
				//characterSheet.setInventorySheet(inventorySheet);
				characterSheet.setCharacter(character);
				return this.characterSheetService.save(characterSheet);
			}

			
			else {
				//TODO: Character already has sheet update it
				return null;
				
			}
		}
		else {
			//TODO: No session.
			return null;
		}

		
		

		
		
	}

	
	
	
	
	/*
	 * @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<CharacterSheet>> findAll() {
	 * 
	 * return new ResponseEntity<List<CharacterSheet>>(this.characterSheetService.findAll(),
	 * HttpStatus.OK); }
	 * 
	 * 
	 * @GetMapping(path = "/name/{name}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public CharacterSheet findByName(@PathVariable String
	 * name) { return this.characterSheetService.findByName(name); }
	 * 
	 * @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public void saveRecipe(@RequestBody CharacterSheet characterSheet) { this.characterSheetService.save(characterSheet);
	 * }
	 * 
	 * @GetMapping(path = "/exception") public void throwException() { throw new
	 * RuntimeException(); }
	 * 
	 * @GetMapping(path = "/exception-handling") public void
	 * throwBusinessException() { throw new BusinessException(); }
	 */
}
