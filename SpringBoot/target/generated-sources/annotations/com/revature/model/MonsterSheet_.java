package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MonsterSheet.class)
public abstract class MonsterSheet_ {

	public static volatile SingularAttribute<MonsterSheet, String> personality;
	public static volatile SingularAttribute<MonsterSheet, String> quests;
	public static volatile SingularAttribute<MonsterSheet, String> name;
	public static volatile SingularAttribute<MonsterSheet, Integer> monsterSheetId;
	public static volatile SingularAttribute<MonsterSheet, String> description;
	public static volatile SingularAttribute<MonsterSheet, String> location;
	public static volatile SingularAttribute<MonsterSheet, String> items;
	public static volatile SingularAttribute<MonsterSheet, DungeonMaster> dungeonMaster;

	public static final String PERSONALITY = "personality";
	public static final String QUESTS = "quests";
	public static final String NAME = "name";
	public static final String MONSTER_SHEET_ID = "monsterSheetId";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String ITEMS = "items";
	public static final String DUNGEON_MASTER = "dungeonMaster";

}

