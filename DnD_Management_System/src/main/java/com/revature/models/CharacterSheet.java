package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "charactersheet_db")

public class CharacterSheet {
	@Column(name = "characterSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterSheetId;
	
	//Character Info (top of character page)
	@Column(name = "char_class") 
	String name;
	@Column(name = "char_class") 
	String char_class;
	@Column(name = "level") 
	String level;
	@Column(name = "background") 
	String background;
	@Column(name = "player_name") 
	String player_name;
	@Column(name = "race") 
	String race;
	@Column(name = "alignment") 
	String alignment;
	@Column(name = "experience_points") 
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
}
