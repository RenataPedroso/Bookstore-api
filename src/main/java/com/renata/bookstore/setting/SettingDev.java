package com.renata.bookstore.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renata.bookstore.service.DBService;

@Profile("dev")
@Configuration
public class SettingDev {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean InstanceDataBase() {
		if(strategy.equals("create")) {
			this.dbService.InstanceDataBase();
		}
		return false;
	}
	
}
