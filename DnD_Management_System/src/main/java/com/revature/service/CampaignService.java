package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.models.Campaign;
import com.revature.repositories.CampaignRepository;

@Transactional
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
	
	public List<Campaign> findAll() {
		return this.campaignRepository.findAll(); 
	}

	public Campaign getById(int id) {
		return this.campaignRepository.getById(id);
	}
	  
	 
}
