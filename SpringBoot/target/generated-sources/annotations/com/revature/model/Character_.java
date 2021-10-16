package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Character.class)
public abstract class Character_ {

	public static volatile SingularAttribute<Character, Campaign> campaign;
	public static volatile SingularAttribute<Character, CharacterSheet> characterSheet;
	public static volatile SingularAttribute<Character, Integer> characterId;
	public static volatile SingularAttribute<Character, DungeonMaster> dungeonMaster;

	public static final String CAMPAIGN = "campaign";
	public static final String CHARACTER_SHEET = "characterSheet";
	public static final String CHARACTER_ID = "characterId";
	public static final String DUNGEON_MASTER = "dungeonMaster";

}

