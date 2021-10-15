package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity


@Table(name = "items_db")

public class Item {
	@Id
	@Column(name = "itemsId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int itemsId;
	
	@Column(name = "name")
	String name;
	@Column(name = "item_type")
	String item_type;
	@Column(name = "quantity")
	int quantity;
	@Column(name = "description")
	String description;
	
	
	@ManyToMany(mappedBy = "items")
	private List<InventorySheet> inventorySheets = new ArrayList<>();
}
