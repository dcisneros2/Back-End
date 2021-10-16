package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NpcSheet.class)
public abstract class NpcSheet_ {

	public static volatile SingularAttribute<NpcSheet, String> personality;
	public static volatile SingularAttribute<NpcSheet, String> quests;
	public static volatile SingularAttribute<NpcSheet, Integer> npcSheetId;
	public static volatile SingularAttribute<NpcSheet, String> name;
	public static volatile SingularAttribute<NpcSheet, String> description;
	public static volatile SingularAttribute<NpcSheet, String> location;
	public static volatile SingularAttribute<NpcSheet, String> items;
	public static volatile SingularAttribute<NpcSheet, DungeonMaster> dungeonMaster;

	public static final String PERSONALITY = "personality";
	public static final String QUESTS = "quests";
	public static final String NPC_SHEET_ID = "npcSheetId";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String ITEMS = "items";
	public static final String DUNGEON_MASTER = "dungeonMaster";

}

