package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CharacterDnd.class)
public abstract class CharacterDnd_ {

	public static volatile SingularAttribute<CharacterDnd, Campaign> campaign;
	public static volatile SingularAttribute<CharacterDnd, CharacterSheet> characterSheet;
	public static volatile SingularAttribute<CharacterDnd, Integer> characterId;
	public static volatile SingularAttribute<CharacterDnd, DungeonMaster> dungeonMaster;

	public static final String CAMPAIGN = "campaign";
	public static final String CHARACTER_SHEET = "characterSheet";
	public static final String CHARACTER_ID = "characterId";
	public static final String DUNGEON_MASTER = "dungeonMaster";

}

