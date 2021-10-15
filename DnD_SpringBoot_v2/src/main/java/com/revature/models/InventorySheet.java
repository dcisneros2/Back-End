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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "inventorySheetId")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "inventory_db")

public class InventorySheet {
	@Id
	@Column(name = "inventorySheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inventorySheetId;
	
	@OneToOne
	@JoinColumn(name = "characterSheetId", unique = true)
	private CharacterSheet characterSheet;
	
	@ManyToMany
	@JoinTable(name = "inventorySheet_items",
			joinColumns = @JoinColumn(name = "inventorySheetId"),
			inverseJoinColumns = @JoinColumn(name = "itemId")
			)
	private List<Item> items = new ArrayList<>();
	
	public CharacterSheet getCharacterSheet(){
		return characterSheet;
	}
	
	public void setCharacterSheet(CharacterSheet characterSheet){
		this.characterSheet = characterSheet;
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
