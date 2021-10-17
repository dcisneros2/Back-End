package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Campaign;

@Repository("campaignRepository")
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
	public Campaign findByName(String name);
}
