package com.renata.bookstore.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renata.bookstore.service.DBService;

@Profile("test")
@Configuration
public class SettingTest {
	
	@Autowired
	private DBService dbService;
		
		@Bean
		public void InstanceDataBase() {	
			this.dbService.InstanceDataBase();	
		}
	
}
