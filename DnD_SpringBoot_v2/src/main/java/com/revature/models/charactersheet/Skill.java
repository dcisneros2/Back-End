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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "skillId")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "skills_db")

public class Skill {
	
	@Id
	@Column(name = "skillId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int skillId;
	
	@Column(name = "name") 
	String name;

	@Column(name = "modifier")
	String modifier;

	@Column(name = "proficiency")
	Boolean proficiency;
	
	@Column(name = "ability")
	String ability;
	
	@ManyToOne
	@JoinColumn(name = "skillSheetId")
	private SkillSheet skillSheet;

	
}
