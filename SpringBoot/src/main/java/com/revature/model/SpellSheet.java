package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "spellsheetdb")

public class SpellSheet {
	@Id
	@Column(name = "spellSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spellSheetId;
	
	//Character Spellcast Info (at top of character sheet)
	@Column(name = "spellcastingclass")
	String spellcasting_class;
	@Column(name = "spellcastingability")
	String spellcasting_ability;
	@Column(name = "spellsavedc")
	int spell_save_dc;
	@Column(name = "spellattackbonus")
	int spell_attack_bonus;
	
	
	//Spell Slots
	@Column(name = "level1slotstotal")
	int level_1_slots_total;
	@Column(name = "level2slotstotal")
	int level_2_slots_total;
	@Column(name = "level3slotstotal")
	int level_3_slots_total;
	@Column(name = "level4slotstotal")
	int level_4_slots_total;
	@Column(name = "level5slotstotal")
	int level_5_slots_total;
	@Column(name = "level6slotstotal")
	int level_6_slots_total;
	@Column(name = "level7slotstotal")
	int level_7_slots_total;
	@Column(name = "level8slotstotal")
	int level_8_slots_total;
	@Column(name = "level9slotstotal")
	int level_9_slots_total;
	
	//Spells Slots Expended
	@Column(name = "level1slotsexpended")
	int level_1_slots_expended;
	@Column(name = "level2slotsexpended")
	int level_2_slots_expended;
	@Column(name = "level3slotsexpended")
	int level_3_slots_expended;
	@Column(name = "level4slotsexpended")
	int level_4_slots_expended;
	@Column(name = "level5slotsexpended")
	int level_5_slots_expended;
	@Column(name = "level6slotsexpended")
	int level_6_slots_expended;
	@Column(name = "level7slotsexpended")
	int level_7_slots_expended;
	@Column(name = "level8slotsexpended")
	int level_8_slots_expended;
	@Column(name = "level9slotsexpended")
	int level_9_slots_expended;
	
	
	@OneToOne
	@JoinColumn(name = "characterSheetId")
	private CharacterSheet characterSheet;
	
	@ManyToMany
	@JoinTable(name = "spellSheetspells",
			joinColumns = @JoinColumn(name = "spellSheetId"),
			inverseJoinColumns = @JoinColumn(name = "spellId")
			)
	private List<Spells> spells;
}
