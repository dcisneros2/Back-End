package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity

@Table(name = "user_db")
public class User {
	@Id
	@Column(name = "playerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerId;

	@Column(name = "username", unique = true)
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "accountType")
	String accountType;

	// #TODO: Decide whether to use cascade, and what type if so
	//Added Ignore due to recurssion occurring with getAll
	@ToString.Exclude
	@ManyToMany(mappedBy = "users")
	private List<Campaign> campaigns = new ArrayList<>();

	public User(String username, String password, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		//this.campaigns = campaigns;
	}
	@JsonIgnore
	public List<Campaign> getCampaigns() {
		return campaigns;
	}
	
	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}
	
	
	
}
