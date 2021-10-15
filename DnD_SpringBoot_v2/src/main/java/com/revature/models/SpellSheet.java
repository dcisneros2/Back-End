package com.revature.models;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity


@Table(name = "spellsheet_db")

public class SpellSheet {
	@Id
	@Column(name = "spellSheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spellSheetId;
	
	//Character Spellcast Info (at top of character sheet)
	@Column(name = "spellcasting_class")
	String spellcasting_class;
	@Column(name = "spellcasting_ability")
	String spellcasting_ability;
	@Column(name = "spell_save_dc")
	int spell_save_dc;
	@Column(name = "spell_attack_bonus")
	int spell_attack_bonus;
	
	
	//Spell Slots
	@Column(name = "level_1_slots_total")
	int level_1_slots_total;
	@Column(name = "level_2_slots_total")
	int level_2_slots_total;
	@Column(name = "level_3_slots_total")
	int level_3_slots_total;
	@Column(name = "level_4_slots_total")
	int level_4_slots_total;
	@Column(name = "level_5_slots_total")
	int level_5_slots_total;
	@Column(name = "level_6_slots_total")
	int level_6_slots_total;
	@Column(name = "level_7_slots_total")
	int level_7_slots_total;
	@Column(name = "level_8_slots_total")
	int level_8_slots_total;
	@Column(name = "level_9_slots_total")
	int level_9_slots_total;
	
	//Spells Slots Expended
	@Column(name = "level_1_slots_expended")
	int level_1_slots_expended;
	@Column(name = "level_2_slots_expended")
	int level_2_slots_expended;
	@Column(name = "level_3_slots_expended")
	int level_3_slots_expended;
	@Column(name = "level_4_slots_expended")
	int level_4_slots_expended;
	@Column(name = "level_5_slots_expended")
	int level_5_slots_expended;
	@Column(name = "level_6_slots_expended")
	int level_6_slots_expended;
	@Column(name = "level_7_slots_expended")
	int level_7_slots_expended;
	@Column(name = "level_8_slots_expended")
	int level_8_slots_expended;
	@Column(name = "level_9_slots_expended")
	int level_9_slots_expended;
	
	
	@OneToOne
	@JoinColumn(name = "characterSheetId")
	private CharacterSheet characterSheet;
	
	@ManyToMany
	@JoinTable(name = "spellSheet_spells",
			joinColumns = @JoinColumn(name = "spellSheetId"),
			inverseJoinColumns = @JoinColumn(name = "spellId")
			)
	private List<Spells> spells = new ArrayList<>();
}
