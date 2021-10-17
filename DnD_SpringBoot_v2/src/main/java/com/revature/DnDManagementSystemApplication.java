package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class DnDManagementSystemApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(DnDManagementSystemApplication.class, args);
	}

}
