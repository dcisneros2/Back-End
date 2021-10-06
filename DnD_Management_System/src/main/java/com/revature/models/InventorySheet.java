package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "inventory_db")

public class InventorySheet {
	@Column(name = "inventorySheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inventorySheetId;
	
	
}
