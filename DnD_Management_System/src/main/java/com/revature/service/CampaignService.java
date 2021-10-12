package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Campaign;
import com.revature.models.User;
import com.revature.repositories.CampaignRepository;
import com.revature.repositories.UserRepository;

@Service("campaignService")
public class CampaignService {
	private CampaignRepository campaignRepository;

	@Autowired
	public CampaignService(CampaignRepository campaignRepository) {

		this.campaignRepository = campaignRepository;
	}

	public void setCampaignRepository(CampaignRepository campaignRepository) {
		this.campaignRepository = campaignRepository;
	}

	public void save(Campaign campaign) {
		this.campaignRepository.save(campaign);
	}

	public Campaign findByName(String name) {
		return this.campaignRepository.findByName(name);
	}

	/*
	 * public User findById(int id) { return this.userRepository.getById(id);
	 * 
	 * }
	 */

	/*
	 * public List<User> findAll(){ return this.userRepository.findAll(); }
	 * 
	 * public void save(User user) { this.userRepository.save(user); }
	 * 
	 * 
	 */
}
