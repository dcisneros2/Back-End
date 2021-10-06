package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "items_db")

public class Items {
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
	
}
