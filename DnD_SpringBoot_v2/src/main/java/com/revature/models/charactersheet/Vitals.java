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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vitalsId")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "vitals_db")

public class Vitals {

	@Id
	@Column(name = "vitalsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int vitalsId;

	@Column(name = "clazz")
	String clazz;
	@Column(name = "level")
	int level;
	@Column(name = "player")
	String player;
	@Column(name = "race")
	String race;
	@Column(name = "alignment")
	String alignment;
	@Column(name = "armorClass")
	int armorClass;
	@Column(name = "initiative")
	String initiative;
	@Column(name = "currentHitDice")
	int currentHitDice;
	@Column(name = "hitDice")
	int hitDice;
	@Column(name = "currentHp")
	int currentHp;
	@Column(name = "totalHp")
	int totalHp;
	@Column(name = "healthPercent")
	int healthPercent;
	@Column(name = "speed")
	String speed;
	@Column(name = "deathSaveSuccess")
	int deathSaveSuccess;
	@Column(name = "deathSaveFailure")
	int deathSaveFailure;

	@ManyToOne
	@JoinColumn(name = "vitalsSheetId")
	private VitalsSheet vitalsSheet;

}
