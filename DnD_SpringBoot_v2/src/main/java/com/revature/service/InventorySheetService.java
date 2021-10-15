package com.revature.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CharacterSheet;
import com.revature.models.InventorySheet;
import com.revature.repositories.CharacterSheetRepository;
import com.revature.repositories.InventorySheetRepository;

@Transactional
@Service("InventorySheetService")

public class InventorySheetService {
	private InventorySheetRepository inventorySheetRepository;

	@Autowired
	public InventorySheetService(InventorySheetRepository inventorySheetRepository) {
		this.inventorySheetRepository = inventorySheetRepository;
	}

	public void setCharacterSheetRepository(InventorySheetRepository inventorySheetRepository) {
		this.inventorySheetRepository = inventorySheetRepository;
	}

	public InventorySheet getById(int id) {
		return this.inventorySheetRepository.getById(id);
	}

	
	public InventorySheet save(InventorySheet inventorySheet) {
		return this.inventorySheetRepository.save(inventorySheet);
	}
}
