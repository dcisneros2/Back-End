package com.revature.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.controller.CampaignController;
import com.revature.models.Campaign;
import com.revature.repositories.CampaignRepository;
import com.revature.service.CampaignService;

@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class testCampaignController {
	
 
		
		@Mock
		private CampaignService campaignService;

		@InjectMocks
		private CampaignController  campaignController;
		
		@Mock
		private CampaignRepository campaignRepository;
		
		
		private Campaign campaign;

		
		private MockMvc mockMvc;
		
		@Before
		public void setup() {
		campaign = new Campaign();
			MockitoAnnotations.openMocks(this);
				
			mockMvc = MockMvcBuilders.standaloneSetup(campaignController).build();
		}
		
		@Test
		public void testSelectCampaign () {
			
		when(campaignRepository.save(Mockito.any(Campaign.class))).thenReturn(campaign);
		Campaign returnuser = new Campaign();
		assertEquals(returnuser, campaign);
		 verify(campaignRepository, times(1)).save(Mockito.any(Campaign.class));
		 
		 
		 
			try {
				mockMvc.perform(get("/createUser")).andExpect(status().isOk()).andExpect(content()
						.contentType(MediaType.APPLICATION_JSON)).andDo( print()).andReturn();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		@Test
		public void testGetCampaign () {
			
			campaign.setName("user");
			when(campaignService.findByName(campaign.getName())).thenReturn(campaign);
			
			Campaign returnuser  = new Campaign();
			returnuser.setName("user");
			assertEquals(returnuser.getName(), campaign);
		}
		
		@Test
		public void testGetAlln() {
			
			when(campaignService.findAll()).thenReturn(Arrays.asList(campaign);
			
			Campaign returnuser  = new Campaign();
			returnuser.setName("user");
			
			
			assertEquals(returnuser, campaign);
			
			assertEquals("user", campaign);
		}
		
	}

}
