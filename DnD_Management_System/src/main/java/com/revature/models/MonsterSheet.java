package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "monstersheet_db")

public class MonsterSheet {
	@Column(name = "monsterSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int monsterSheetId;
	
	@Column(name = "name")
	String name;
	@Column(name = "personality")
	String personality;
	@Column(name = "description")
	String description;
	@Column(name = "location")
	String location;
	@Column(name = "items")
	String items;
	@Column(name = "quests")
	String quests;
}
