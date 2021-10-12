package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Campaign;
import com.revature.service.CampaignService;

@RestController("CampaignController")
@RequestMapping("/campaign")
public class CampaignController {
	private CampaignService campaignService;
	
	@Autowired
	public CampaignController(CampaignService campaignService) {
		this.campaignService = campaignService;
	}
	
	//TODO: Return message if campaign is made or not. Add Json return to GetMapping.
	@PostMapping(path = "/createCampaign", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCampaign(@RequestBody Campaign campaign) {
/*		Campaign campaign = new Campaign(
				queryParams.get("name"),
				Integer.valueOf(queryParams.get("playerCount"))
				);*/
		this.campaignService.save(campaign);
	}
	
	//@GetMapping("/getUser/{id}")
	//public User getUserById() {
	//	return null;
		
	//}
	
	@GetMapping(path = "/getCampaign", produces = MediaType.APPLICATION_JSON_VALUE)
	public Campaign getCampaignByName(@RequestParam String name) {
		System.out.println(name);
		return this.campaignService.findByName(name);
	}

	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Campaign>> getAllCampaigns(){
		return new ResponseEntity<List<Campaign>>(this.campaignService.findAll(), HttpStatus.OK);
	}
	
}
