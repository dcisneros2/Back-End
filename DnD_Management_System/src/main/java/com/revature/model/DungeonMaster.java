package com.revature.model;

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
@Table(name = "dungeonmasterdb")
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
	private List<NpcSheet> npcSheets;
	
	@OneToMany(mappedBy = "dungeonMaster")
	private List<MonsterSheet> monsterSheets;
	
	@OneToMany(mappedBy = "dungeonMaster")
	private List<CharacterDnd> characters;
}
