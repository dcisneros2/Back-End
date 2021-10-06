package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity


@Table(name = "user_db")
public class User {
	@Column(name = "playerId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerId;
	
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "accountType")
	String accountType;
}
