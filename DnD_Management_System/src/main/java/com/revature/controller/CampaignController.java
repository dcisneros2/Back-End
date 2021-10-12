package com.revature.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Campaign;
import com.revature.models.User;
import com.revature.service.CampaignService;
import com.revature.service.UserService;

@RestController("CampaignController")

public class CampaignController {
	private CampaignService campaignService;
	
	@Autowired
	public CampaignController(CampaignService campaignService) {
		this.campaignService = campaignService;
	}
	//TODO: Return message if campaign is made or not. Add Json return to GetMapping.
	@GetMapping("/createCampaign")
	public void createUser(@RequestParam Map<String, String> queryParams) {
		Campaign campaign = new Campaign(
				queryParams.get("name"),
				Integer.valueOf(queryParams.get("playercount"))
				);
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

	
	
	/*
	 * @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<User>> findAll() {
	 * 
	 * return new ResponseEntity<List<User>>(this.userService.findAll(),
	 * HttpStatus.OK); }
	 * 
	 * 
	 * @GetMapping(path = "/name/{name}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public User findByName(@PathVariable String
	 * name) { return this.userService.findByName(name); }
	 * 
	 * @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public void saveRecipe(@RequestBody User user) { this.userService.save(user);
	 * }
	 * 
	 * @GetMapping(path = "/exception") public void throwException() { throw new
	 * RuntimeException(); }
	 * 
	 * @GetMapping(path = "/exception-handling") public void
	 * throwBusinessException() { throw new BusinessException(); }
	 */
}
