package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.charactersheet.InventorySheet;
import com.revature.models.charactersheet.SpellSheet;

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

@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "characterSheetId")

@Table(name = "charactersheet_db")

public class CharacterSheet {
	@Id
	@Column(name = "characterSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterSheetId;

	@Column(name = "name")
	String name;
	@Column(name = "campaign")
	String campaign;
	
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinColumn(name = "characterId")
	private CharacterDnd character;
	
	@OneToOne(mappedBy = "characterSheet")
	private InventorySheet inventorySheet;
	
	@OneToOne(mappedBy = "characterSheet")
	private SpellSheet spellSheet;


	
}
