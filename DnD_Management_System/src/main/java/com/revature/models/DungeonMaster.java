package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "dungeonmaster_db")
public class DungeonMaster {
	@Column(name = "dungeonMasterId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dungeonMasterId;
	
	String name;
}
