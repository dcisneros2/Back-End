package com.revature.login;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> accountType;
	public static volatile SingularAttribute<User, Integer> playerId;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ACCOUNT_TYPE = "accountType";
	public static final String PLAYER_ID = "playerId";
	public static final String USERNAME = "username";

}

