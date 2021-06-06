package fr.jdr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.jdr.spring.services.UserService;
import fr.jdr.spring.services.servicesimpl.UserServiceImpl;


@Configuration
public class ServiceConfig {
	
	
	
	/**
	 *
	 * @return
	 */
	@Bean
	public UserService UserServiceFactory() {
		return new UserServiceImpl();
		
	}
	

}
