package com.revature;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class DnDManagementSystemApplicationTests {

	@Test
	void contextLoads() {
		
	}

}
