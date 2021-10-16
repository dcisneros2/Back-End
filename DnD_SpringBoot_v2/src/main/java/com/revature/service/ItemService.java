package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.models.charactersheet.Item;
import com.revature.repositories.ItemRepository;

@Service("itemService")
public class ItemService {
	private ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository itemRepository) {

		this.itemRepository = itemRepository;
	}

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> getAll(int id){
		return this.itemRepository.findAll();
	}
	
	
	public Item save(Item item) {
		return this.itemRepository.save(item);
	}
	
	public void delete(Item item) {
		this.itemRepository.delete(item);
	}
	
	public Item findByName(String name) {
		return this.itemRepository.findByName(name);
	}
	
	public Item getById(int id) {
		return this.itemRepository.getById(id);
	}
}
