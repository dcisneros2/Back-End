package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "userdb")
public class User {
	@Id
	@Column(name = "playerId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerId;
	
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "accountType")
	String accountType;
	
	
	//#TODO: Decide whether to use cascade, and what type if so
	@ManyToMany
	@JoinTable(name = "usercampaign",
			joinColumns = @JoinColumn(name = "playerId"),
			inverseJoinColumns = @JoinColumn(name = "campaignId")
			)
	private List<Campaign> campaigns;

}
