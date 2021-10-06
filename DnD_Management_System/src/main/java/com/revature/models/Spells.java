package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "spells_db")

public class Spells {
	@Column(name = "spellId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spellId;
	
	@Column(name = "name")
	String name;
	@Column(name = "level")
	int level;
	@Column(name = "description")
	String description;
}
