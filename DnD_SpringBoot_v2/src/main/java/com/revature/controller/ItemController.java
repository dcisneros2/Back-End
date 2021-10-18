package com.revature.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.CharacterSheet;
import com.revature.models.charactersheet.Item;
import com.revature.repositories.ItemRepository;
import com.revature.service.CharacterDndService;
import com.revature.service.ItemService;

@RestController("itemController")
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private CharacterDndService characterDndService;
	
	@Autowired
	private ItemService itemService;
	
	
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterSheet> createItem(@RequestBody Item item, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if(character != null) {
				character.getCharacterSheet().getInventorySheet().getItems().add(item);
				item.setInventorySheet(character.getCharacterSheet().getInventorySheet());
				this.itemService.save(item);
				return new ResponseEntity<CharacterSheet>(character.getCharacterSheet(), HttpStatus.OK);
			}
			else {
				//TODO: No character selected
				return new ResponseEntity<CharacterSheet>(HttpStatus.BAD_REQUEST);
			}	
		}
		
		else {
			return new ResponseEntity<CharacterSheet>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@PostMapping(path = "/update")
	public Item updateItem(@RequestBody Item item, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if(character != null) {
				//Update item with parameter values
				character.getCharacterSheet().getInventorySheet().getItems();
				item.setInventorySheet(character.getCharacterSheet().getInventorySheet());

				return this.itemService.save(item);
			}
			else {
				//TODO: No character selected
				return null;
			}
				
		}
		
		else {
			
			return null;
		}
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAll(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			int id = character.getCharacterSheet().getInventorySheet().getInventorySheetId();
			return itemService.getAll(id);
		}
		else {
			//TODO: No session
			return null;
		}
	
		
	}
	
	
	@PostMapping(path = "/delete")
	public void deleteItem(@RequestParam String name, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if(character != null) {
				Item item = itemService.findByName(name);
				List<Item> items= character.getCharacterSheet().getInventorySheet().getItems();
				items.remove(item);
				character.getCharacterSheet().getInventorySheet().setItems(items);
				itemService.delete(item);
				
			}
			else {
				//TODO: No character selected
			}
		}
		else {
			//TODO: No session
		}
	}
	
	@GetMapping(path = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void getAllItems(@RequestParam String name, HttpServletRequest request) {
		
	}
}