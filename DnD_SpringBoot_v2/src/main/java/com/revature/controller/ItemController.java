package com.revature.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CharacterDnd;
import com.revature.models.Item;
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
	
	
	
	@PostMapping(path = "/create")
	public Item createItem(@RequestParam Map<String, String> queryParams, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if(character != null) {
				//Create item with parameter values
				Item item = new Item();
				item.setName(queryParams.get("name"));
				item.setDescription(queryParams.get("description"));
				item.setQuantity(Integer.valueOf(queryParams.get("quantity")));
				item.setItemType(queryParams.get("itemType"));
				
				character.getCharacterSheet().getInventorySheet().getItems().add(item);
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
	
	@PostMapping(path = "/update")
	public Item updateItem(@RequestParam Map<String, String> queryParams, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			CharacterDnd character = characterDndService.getById((Integer)session.getAttribute("characterId"));
			if(character != null) {
				//Update item with parameter values
				
				Item item = itemService.getById(Integer.valueOf(queryParams.get("itemId")));
				
				//List<Item> items = character.getCharacterSheet().getInventorySheet().getItems();
				item.setName(queryParams.get("name"));
				item.setDescription(queryParams.get("description"));
				item.setQuantity(Integer.valueOf(queryParams.get("quantity")));
				item.setItemType(queryParams.get("itemType"));
				
				
				//character.getCharacterSheet().getInventorySheet().getItems().contains(item);
				//item.setInventorySheet(character.getCharacterSheet().getInventorySheet());
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
			int id = character.getCharacterSheet().getCharacterSheetId();
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