package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itemsdb")

public class Items {
	@Id
	@Column(name = "itemsId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int itemsId;
	
	@Column(name = "name")
	String name;
	@Column(name = "itemtype")
	String item_type;
	@Column(name = "quantity")
	int quantity;
	@Column(name = "description")
	String description;
	
	
	@ManyToMany(mappedBy = "items")
	private List<InventorySheet> inventorySheets;
}
