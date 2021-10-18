package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.InventorySheet;
import com.revature.service.CharacterDndService;
import com.revature.service.CharacterSheetService;
import com.revature.service.InventorySheetService;

@RestController("SpellSheetController")

@RequestMapping("/spell")
public class SpellSheetController {
	
	@Autowired
	private CharacterDndService characterDndService;
	
	private InventorySheetService inventorySheetService;
	
	
	@Autowired
	public SpellSheetController(InventorySheetService inventorySheetService) {
		this.inventorySheetService = inventorySheetService;
		}
	
	
	@GetMapping(path = "/create",  produces = MediaType.APPLICATION_JSON_VALUE)
	public InventorySheet createCharacterSheet(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			
			
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			
			if(character.getCharacterSheet().getInventorySheet() == null) {
				InventorySheet inventorySheet = new InventorySheet();
				//inventorySheetService.getById(character.getCharacterSheet().getCharacterSheetId());
				
				character.getCharacterSheet().setInventorySheet(inventorySheet);
				inventorySheet.setCharacterSheet(character.getCharacterSheet());
				return inventorySheetService.save(inventorySheet);
			}
			else
				return character.getCharacterSheet().getInventorySheet();

		}
		else {
			//TODO: No session. Should not happen.
			return null;
		}

	}
}
