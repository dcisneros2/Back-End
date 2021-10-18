package com.revature.models.charactersheet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.CharacterSheet;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

// Lombok
@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "actionId", scope = Action.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "action_db")

public class Action {
	
	@Id
	@Column(name = "actionId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int actionId;
	
	@Column(name = "name") 
	String name;

	@Column(name = "attackBonus")
	String attackBonus;
	
	@Column(name = "damage")
	String damage;
	
	@Column(name = "type")
	String type;
	
	@ManyToOne
	@JoinColumn(name = "actionSheetId", unique = true)
	private ActionSheet actionSheet;

	
}
