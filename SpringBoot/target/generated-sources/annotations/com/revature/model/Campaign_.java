package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Campaign.class)
public abstract class Campaign_ {

	public static volatile SingularAttribute<Campaign, Integer> player_count;
	public static volatile ListAttribute<Campaign, Character> characters;
	public static volatile ListAttribute<Campaign, DungeonMaster> dungeonMasters;
	public static volatile SingularAttribute<Campaign, Integer> campaignId;
	public static volatile ListAttribute<Campaign, User> users;

	public static final String PLAYER_COUNT = "player_count";
	public static final String CHARACTERS = "characters";
	public static final String DUNGEON_MASTERS = "dungeonMasters";
	public static final String CAMPAIGN_ID = "campaignId";
	public static final String USERS = "users";

}

