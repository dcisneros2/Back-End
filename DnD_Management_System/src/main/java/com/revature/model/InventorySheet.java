package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventorydb")

public class InventorySheet {
	@Id
	@Column(name = "inventorySheetId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inventorySheetId;
	
	@OneToOne
	@JoinColumn(name = "characterSheetId")
	private CharacterSheet characterSheet;
	
	@ManyToMany
	@JoinTable(name = "inventorySheetitems",
			joinColumns = @JoinColumn(name = "inventorySheetId"),
			inverseJoinColumns = @JoinColumn(name = "itemId")
			)
	private List<Items> items;
}
