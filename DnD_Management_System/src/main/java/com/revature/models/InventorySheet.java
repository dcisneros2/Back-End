package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_db")

public class InventorySheet {
	@Id
	@Column(name = "inventorySheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inventorySheetId;
	
	@OneToOne
	@JoinColumn(name = "characterSheetId")
	private CharacterSheet characterSheet;
	
	@ManyToMany
	@JoinTable(name = "inventorySheet_items",
			joinColumns = @JoinColumn(name = "inventorySheetId"),
			inverseJoinColumns = @JoinColumn(name = "itemId")
			)
	private List<Items> items = new ArrayList<>();
}
