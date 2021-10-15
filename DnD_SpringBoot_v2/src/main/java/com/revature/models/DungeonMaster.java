package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity


@Table(name = "dungeonmaster_db")
public class DungeonMaster {
	@Id
	@Column(name = "dungeonMasterId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dungeonMasterId;
	
	@Column(name = "name")
	String name;
	
	
	@ManyToOne
	@JoinColumn(name = "campaignId")
	private Campaign campaign;
	
	@OneToMany(mappedBy = "dungeonMaster")
	private List<NpcSheet> npcSheets = new ArrayList<>();
	
	@OneToMany(mappedBy = "dungeonMaster")
	private List<MonsterSheet> monsterSheets = new ArrayList<>();
	
	@OneToMany(mappedBy = "dungeonMaster")
	private List<CharacterDnd> characters = new ArrayList<>();
}
