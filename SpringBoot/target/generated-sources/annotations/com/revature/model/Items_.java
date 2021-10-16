package com.revature.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Items.class)
public abstract class Items_ {

	public static volatile ListAttribute<Items, InventorySheet> inventorySheets;
	public static volatile SingularAttribute<Items, Integer> quantity;
	public static volatile SingularAttribute<Items, String> item_type;
	public static volatile SingularAttribute<Items, Integer> itemsId;
	public static volatile SingularAttribute<Items, String> name;
	public static volatile SingularAttribute<Items, String> description;

	public static final String INVENTORY_SHEETS = "inventorySheets";
	public static final String QUANTITY = "quantity";
	public static final String ITEM_TYPE = "item_type";
	public static final String ITEMS_ID = "itemsId";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

}

