package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DungeonMaster.class)
public abstract class DungeonMaster_ {

	public static volatile ListAttribute<DungeonMaster, CharacterDnd> characters;
	public static volatile ListAttribute<DungeonMaster, MonsterSheet> monsterSheets;
	public static volatile SingularAttribute<DungeonMaster, String> name;
	public static volatile SingularAttribute<DungeonMaster, Campaign> campaign;
	public static volatile ListAttribute<DungeonMaster, NpcSheet> npcSheets;
	public static volatile SingularAttribute<DungeonMaster, Integer> dungeonMasterId;

	public static final String CHARACTERS = "characters";
	public static final String MONSTER_SHEETS = "monsterSheets";
	public static final String NAME = "name";
	public static final String CAMPAIGN = "campaign";
	public static final String NPC_SHEETS = "npcSheets";
	public static final String DUNGEON_MASTER_ID = "dungeonMasterId";

}

