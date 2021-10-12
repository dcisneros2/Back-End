package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

@Entity


@Table(name = "campaign_db")
public class Campaign {
	@Id
	@Column(name = "campaignId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int campaignId;
	
	@Column(name = "name")
	String name;
	@Column(name = "player_count") 
	int playerCount;
	
	
	@ManyToMany(mappedBy = "campaigns")
	private List <User> users = new ArrayList<>(); 
	
	@OneToMany(mappedBy = "campaign")
	private List <CharacterDnd> characters = new ArrayList<>();
	
	@OneToMany(mappedBy = "campaign")
	private List <DungeonMaster> dungeonMasters = new ArrayList<>();
	
	
	public Campaign(String name, int playerCount) {
		this.name = name;
		this.playerCount = playerCount;
	}
	
}
