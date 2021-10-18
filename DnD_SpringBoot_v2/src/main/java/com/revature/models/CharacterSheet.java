package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.ActionSheet;
import com.revature.models.charactersheet.FeatureSheet;
import com.revature.models.charactersheet.InventorySheet;
import com.revature.models.charactersheet.MoneySheet;
import com.revature.models.charactersheet.ProficiencySheet;
import com.revature.models.charactersheet.SkillSheet;
import com.revature.models.charactersheet.SpellSheet;
import com.revature.models.charactersheet.TraitSheet;
import com.revature.models.charactersheet.VitalsSheet;

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

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "characterSheetId")

@Table(name = "charactersheet_db")

public class CharacterSheet {
	@Id
	@Column(name = "characterSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int characterSheetId;

	@Column(name = "name")
	String name;
	@Column(name = "campaign")
	String campaign;
	
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JsonIgnore
	@JoinColumn(name = "characterId")
	private CharacterDnd character;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private AbilitySheet abilitySheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private ActionSheet actionSheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private FeatureSheet featureSheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private InventorySheet inventorySheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private MoneySheet moneySheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private ProficiencySheet proficiencySheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private SkillSheet skillSheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private SpellSheet spellSheet;

	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private TraitSheet TraitSheet;
	
	@OneToOne(mappedBy = "characterSheet", cascade = CascadeType.ALL)
	private VitalsSheet vitalsSheet;
	
}
