package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Campaign;


public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
	public Campaign findByName(String name);
}
