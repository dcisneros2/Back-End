package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InventorySheet.class)
public abstract class InventorySheet_ {

	public static volatile SingularAttribute<InventorySheet, Integer> inventorySheetId;
	public static volatile SingularAttribute<InventorySheet, CharacterSheet> characterSheet;
	public static volatile ListAttribute<InventorySheet, Items> items;

	public static final String INVENTORY_SHEET_ID = "inventorySheetId";
	public static final String CHARACTER_SHEET = "characterSheet";
	public static final String ITEMS = "items";

}

