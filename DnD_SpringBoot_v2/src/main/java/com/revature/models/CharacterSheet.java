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
	
	//Character Info (top of character page)
	@Column(name = "name", unique = true) 
	String name;
	@Column(name = "charClass") 
	String char_class;
	@Column(name = "level") 
	String level;
	@Column(name = "background") 
	String background;
	@Column(name = "playerName") 
	String player_name;
	@Column(name = "race") 
	String race;
	@Column(name = "alignment") 
	String alignment;
	@Column(name = "experiencePoints") 
	String experience_points;

	//Ability Scores
	@Column(name = "strength") 
	int strength;
	@Column(name = "dexterity") 
	int dexterity;
	@Column(name = "constitution") 
	int constitution;
	@Column(name = "intelligence") 
	int intelligence;
	@Column(name = "wisdom") 
	int wisdom;
	@Column(name = "charisma") 
	int charisma;
	@Column(name = "overall_strength") 
	int overall_strength;
	@Column(name = "overall_dexterity") 
	int overall_dexterity;
	@Column(name = "overall_constitution") 
	int overall_constitution;
	@Column(name = "overall_intelligence") 
	int overall_intelligence;
	@Column(name = "overall_wisdom") 
	int overall_wisdom;
	@Column(name = "overall_charisma") 
	int overall_charisma;
	
	//Inspiration
	@Column(name = "inspiration") 
	String inspiration;
	
	//Proficiency
	@Column(name = "proficiency_bonus") 
	int proficiency_bonus;
	
	//Saving Throws
	@Column(name = "saving_strength")
	int saving_strength;
	@Column(name = "saving_dexterity")
	int saving_dexterity;
	@Column(name = "saving_constitution")
	int saving_constitution;
	@Column(name = "saving_intelligence")
	int saving_intelligence;
	@Column(name = "saving_wisdom")
	int saving_wisdom;
	@Column(name = "saving_charisma")
	int saving_charisma;
	
	//Skills
	@Column(name = "acrobatics")
	int acrobatics;
	@Column(name = "animal_handling")
	int animal_handling;
	@Column(name = "arcana")
	int arcana;
	@Column(name = "athletics")
	int athletics;
	@Column(name = "deception")
	int deception;
	@Column(name = "history")
	int history;
	@Column(name = "insight")
	int insight;
	@Column(name = "intimidation")
	int intimidation;
	@Column(name = "investigation")
	int investigation;
	@Column(name = "medicine")
	int medicine;
	@Column(name = "nature")
	int nature;
	@Column(name = "perception")
	int perception;
	@Column(name = "performance")
	int performance;
	@Column(name = "persuassion")
	int persuassion;
	@Column(name = "religion")
	int religion;
	@Column(name = "sleight_of_hand")
	int sleight_of_hand;
	@Column(name = "stealth")
	int stealth;
	@Column(name = "survival")
	int survival;
	
	//Passive Wisdom(perception)
	@Column(name = "passive_wisdom")
	int passive_wisdom;
	
	//HP,Armor,Speed,Initiative Stats
	@Column(name = "armor_class")
	int armor_class;
	@Column(name = "initiative")
	int initiative;
	@Column(name = "speed")
	int speed;
	@Column(name = "hit_point_maximum")
	int hit_point_maximum;
	@Column(name = "current_hit_points")
	int current_hit_points;
	@Column(name = "temporary_hit_points")
	int temporary_hit_points;
	@Column(name = "total_hit_dice")
	int total_hit_dice;
	@Column(name = "hit_dice")
	String hit_dice;
	@Column(name = "death_save_successes")
	int death_save_successes;
	@Column(name = "death_save_failures")
	int death_save_failures;
	
	
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinColumn(name = "characterId")
	private CharacterDnd character;
	
	@OneToOne(mappedBy = "characterSheet")
	private InventorySheet inventorySheet;
	
	@OneToOne(mappedBy = "characterSheet")
	private SpellSheet spellSheet;

	public CharacterSheet(String name, String char_class, String level, String background, String player_name,
			String race, String alignment, String experience_points) {
		super();
		this.name = name;
		this.char_class = char_class;
		this.level = level;
		this.background = background;
		this.player_name = player_name;
		this.race = race;
		this.alignment = alignment;
		this.experience_points = experience_points;
	}
	

	
}
