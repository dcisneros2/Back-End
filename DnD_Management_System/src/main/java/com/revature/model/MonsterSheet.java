package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "monstersheetdb")

public class MonsterSheet {
	@Id
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
	
	
	@ManyToOne
	@JoinColumn(name = "dungeonMasterId")
	private DungeonMaster dungeonMaster;
}
