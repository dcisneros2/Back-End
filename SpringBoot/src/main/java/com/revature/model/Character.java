package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "characterdb")

public class Character {
	@Id
	@Column(name = "characterId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterId;
	
	
	@ManyToOne
	@JoinColumn(name = "campaignId")
	private Campaign campaign;
	
	@OneToOne(mappedBy="character")
	private CharacterSheet characterSheet;
	
	@ManyToOne
	@JoinColumn(name = "dungeonMasterId")
	private DungeonMaster dungeonMaster;
}