package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "campaignId")
@Table(name = "campaign_db")
public class Campaign {
	@Id
	@Column(name = "campaignId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int campaignId;
	
	@Column(name = "name", unique = true)
	String name;
	@Column(name = "player_count") 
	int playerCount;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "campaign_user", joinColumns = @JoinColumn(name = "campaignId"), inverseJoinColumns = @JoinColumn(name = "playerId"))
	private List <User> users = new ArrayList<>(); 
	
	@OneToMany(mappedBy = "campaign")
	private List <CharacterDnd> characters = new ArrayList<>();
	
	@OneToMany(mappedBy = "campaign")
	private List <DungeonMaster> dungeonMasters = new ArrayList<>();
	
	
	public Campaign(String name, int playerCount) {
		this.name = name;
		this.playerCount = playerCount;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List <User> users) {
		this.users = users;
	}
	
	public List<CharacterDnd> getCharacters() {
		return characters;
	}
	
	public void setCharacters(List<CharacterDnd> characters) {
		this.characters = characters;
	}
	
	public List<DungeonMaster> getDungeonMasters() {
		return dungeonMasters;
	}
	
	public void setDungeonMasters(List<DungeonMaster> dungeonMasters) {
		this.dungeonMasters = dungeonMasters;
	}
	
	
}
