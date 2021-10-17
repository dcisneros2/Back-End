package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer>{

	public Item findByName(String name);
	
}