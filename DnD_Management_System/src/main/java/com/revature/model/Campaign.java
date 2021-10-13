package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "campaigndb")
public class Campaign {
	@Id
	@Column(name = "campaignId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int campaignId;
	
	@Column(name = "playercount") 
	int player_count;
	
	
	@ManyToMany(mappedBy = "campaigns")
	private List <User> users ; 
	
	@OneToMany(mappedBy = "campaign")
	private List <Character> characters;
	
	@OneToMany(mappedBy = "campaign")
	private List <DungeonMaster> dungeonMasters;
}
