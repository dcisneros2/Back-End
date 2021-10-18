package com.revature.models.charactersheet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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


//Lombok
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "spellSheetId", scope = SpellSheet.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "spellsheet_db")

public class SpellSheet {
	@Id
	@Column(name = "spellSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spellSheetId;
	
	//Character Spellcast Info (at top of character sheet)
	@Column(name = "spellcasting_class")
	String spellcastingClass;
	@Column(name = "spellcasting_ability")
	String spellcastingAbility;
	@Column(name = "spell_save_dc")
	int spellSaveDc;
	@Column(name = "spell_attack_bonus")
	int spellAttackBonus;
	
	@OneToOne
	@JoinColumn(name = "characterSheetId", unique = true)
	private CharacterSheet characterSheet;
	
	@OneToMany(mappedBy = "spellSheet")
	private List<Spell> spells = new ArrayList<>();
}
