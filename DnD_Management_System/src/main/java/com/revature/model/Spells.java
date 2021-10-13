package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "spellsdb")

public class Spells {
	@Id
	@Column(name = "spellId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spellId;
	
	@Column(name = "name")
	String name;
	@Column(name = "level")
	int level;
	@Column(name = "description")
	String description;


	@ManyToMany(mappedBy = "spells")
	private List<SpellSheet> spellSheets;

}
