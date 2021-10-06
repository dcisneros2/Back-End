package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "character_db")

public class Character {
	@Column(name = "characterId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterId;
	
	
}
