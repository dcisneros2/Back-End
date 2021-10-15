package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Campaign;
import com.revature.models.User;
import com.revature.service.CampaignService;
import com.revature.service.UserService;

import lombok.ToString;

@ToString

@RestController("CampaignController")
@RequestMapping("/campaign")
public class CampaignController {
	private CampaignService campaignService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public CampaignController(CampaignService campaignService, UserService userService) {
		this.campaignService = campaignService;
	}
	
	
	
	//TODO: Return message if campaign is made or not. Add Json return to GetMapping.
	//TODO: Add exception handling for duplicate campaign
	@PostMapping(path = "/createCampaign", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCampaign(@RequestParam Map<String, String>queryParams, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			Campaign campaign = new Campaign(queryParams.get("name"),Integer.valueOf(queryParams.get("playerCount")));
			//Get User object from session
			User user = userService.findById((Integer) session.getAttribute("userId"));
			if(user != null) {
				//Add user to new campaign.
				user.getCampaigns().add(campaign);
				campaign.getUsers().add(user);
				
				this.campaignService.save(campaign);
			}
			else {
				//No user is logged in (should not happen)
			}
		}
		else {
			//TODO: Send return message no session found.
			System.out.println("Session not found");
		}
	
	}
	
	@PostMapping(path = "/selectCampaign")
	public void selectCampaign(@RequestParam String name,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			//Get User object from session
			User user = userService.findById((Integer) session.getAttribute("userId"));
			if(user != null) {
				//Add user to existing campaign.
				Campaign campaign = this.campaignService.findByName(name);
				
				if(campaign != null) {
					//Save current campaign id
					session.setAttribute("currentCampaignId", campaign.getCampaignId());
					
					user.getCampaigns().add(campaign);
					campaign.getUsers().add(user);
					this.campaignService.save(campaign);
					
				}
				else {
					//#TODO: Send return message that it is not found.
					System.out.println("Campaign not found");
				}
			}
		}
		else {
			//#TODO: Send return message that session is not found.
			System.out.println("Session not found");
		}
	}
	
	@GetMapping(path = "/getCampaign", produces = MediaType.APPLICATION_JSON_VALUE)
	public Campaign getCampaignByName(@RequestParam String name) {
		System.out.println(name);
		return this.campaignService.findByName(name);
	}

	
	@GetMapping(path = "/getUserCampaigns", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getAllCampaigns(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null) {
			User user = (User) userService.findById((Integer) session.getAttribute("userId"));
			
			//get campaigns
			List<String> campaignNames = new ArrayList<>();
			Campaign campaign = new Campaign();
			for(int x = 0; x < user.getCampaigns().size(); x++) {
				campaign = user.getCampaigns().get(x);
				campaignNames.add(campaign.getName());
			}
			return new ResponseEntity<List<String>>(campaignNames, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		

	}
	
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Campaign>> getAllCampaigns(){
		return new ResponseEntity<List<Campaign>>(this.campaignService.findAll(), HttpStatus.OK);
	}
	
	
	
}
