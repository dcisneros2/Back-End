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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "traitId", scope = Trait.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "trait_db")

public class Trait {
	
	@Id
	@Column(name = "traitId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int traitId;
	
	@ManyToOne
	@JoinColumn(name = "abilitySheetId", unique = true)
	private TraitSheet traitSheet;

}
