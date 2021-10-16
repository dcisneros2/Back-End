package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Spells.class)
public abstract class Spells_ {

	public static volatile ListAttribute<Spells, SpellSheet> spellSheets;
	public static volatile SingularAttribute<Spells, Integer> level;
	public static volatile SingularAttribute<Spells, String> name;
	public static volatile SingularAttribute<Spells, String> description;
	public static volatile SingularAttribute<Spells, Integer> spellId;

	public static final String SPELL_SHEETS = "spellSheets";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String SPELL_ID = "spellId";

}

