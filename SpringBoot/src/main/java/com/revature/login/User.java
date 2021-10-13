package com.revature.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "user")
public class User {


	
		@Id
		@Column(name = "playerId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int playerId;

		@Column(name = "username", unique = true)
		String username;
		@Column(name = "password")
		String password;
		@Column(name = "Role")
		String accountType;

		
}