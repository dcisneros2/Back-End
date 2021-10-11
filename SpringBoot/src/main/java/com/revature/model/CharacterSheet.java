package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "charactersheetdb")

public class CharacterSheet {
	@Id
	@Column(name = "characterSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterSheetId;
	
	//Character Info (top of character page)
	@Column(name = "name") 
	String name;
	@Column(name = "charclass") 
	String char_class;
	@Column(name = "level") 
	String level;
	@Column(name = "background") 
	String background;
	@Column(name = "playername") 
	String player_name;
	@Column(name = "race") 
	String race;
	@Column(name = "alignment") 
	String alignment;
	@Column(name = "experiencepoints") 
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
	@Column(name = "overallstrength") 
	int overall_strength;
	@Column(name = "overalldexterity") 
	int overall_dexterity;
	@Column(name = "overallconstitution") 
	int overall_constitution;
	@Column(name = "overallintelligence") 
	int overall_intelligence;
	@Column(name = "overallwisdom") 
	int overall_wisdom;
	@Column(name = "overallcharisma") 
	int overall_charisma;
	
	//Inspiration
	@Column(name = "inspiration") 
	String inspiration;
	
	//Proficiency
	@Column(name = "proficiencybonus") 
	int proficiency_bonus;
	
	//Saving Throws
	@Column(name = "savingstrength")
	int saving_strength;
	@Column(name = "savingdexterity")
	int saving_dexterity;
	@Column(name = "savingconstitution")
	int saving_constitution;
	@Column(name = "savingintelligence")
	int saving_intelligence;
	@Column(name = "savingwisdom")
	int saving_wisdom;
	@Column(name = "savingcharisma")
	int saving_charisma;
	
	//Skills
	@Column(name = "acrobatics")
	int acrobatics;
	@Column(name = "animalhandling")
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
	@Column(name = "sleightofhand")
	int sleight_of_hand;
	@Column(name = "stealth")
	int stealth;
	@Column(name = "survival")
	int survival;
	
	//Passive Wisdom(perception)
	@Column(name = "passivewisdom")
	int passive_wisdom;
	
	//HP,Armor,Speed,Initiative Stats
	@Column(name = "armorclass")
	int armor_class;
	@Column(name = "initiative")
	int initiative;
	@Column(name = "speed")
	int speed;
	@Column(name = "hitpointmaximum")
	int hit_point_maximum;
	@Column(name = "currenthitpoints")
	int current_hit_points;
	@Column(name = "temporaryhitpoints")
	int temporary_hit_points;
	@Column(name = "totalhitdice")
	int total_hit_dice;
	@Column(name = "hitdice")
	String hit_dice;
	@Column(name = "deathsavesuccesses")
	int death_save_successes;
	@Column(name = "deathsavefailures")
	int death_save_failures;
	
	
	@OneToOne
	@JoinColumn(name = "characterId")
	private Character character;
	
	@OneToOne(mappedBy = "characterSheet")
	private InventorySheet inventorySheet;
	
	@OneToOne(mappedBy = "characterSheet")
	private SpellSheet spellSheet;
	
	
}
