package fr.jdr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.Session;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.servicesimpl.CreneauServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameServiceImpl;
import fr.jdr.spring.services.servicesimpl.SessionServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public GenericService<Creneau> creneauServiceFactory(){
		return new CreneauServiceImpl();
	}
	
	@Bean
	public GenericService<Game> gameServiceFactory(){
		return new GameServiceImpl();
	}
	
	@Bean
	public GenericService<Session> sessionServiceFactory(){
		return new SessionServiceImpl();
	}

}
