package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity


@Table(name = "campaign_db")
public class Campaign {
	@Column(name = "campaignId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int campaignId;
	
	@Column(name = "player_count") 
	int player_count;
}
