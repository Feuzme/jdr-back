package fr.jdr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.jdr.spring.services.UserService;
import fr.jdr.spring.services.servicesimpl.UserServiceImpl;
import fr.jdr.spring.models.ComposantEdit;
import fr.jdr.spring.models.ComposantStandard;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.Session;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.servicesimpl.ComposantEditImpl;
import fr.jdr.spring.services.servicesimpl.ComposantStandardImpl;
import fr.jdr.spring.services.servicesimpl.CreneauServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameServiceImpl;
import fr.jdr.spring.services.servicesimpl.SessionServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public GenericService<ComposantStandard> composantStandardServiceFactory() {
		return new ComposantStandardImpl();
	}
	
	@Bean
	public GenericService<ComposantEdit> composantEditServiceFactory() {
		return new ComposantEditImpl();
	}
	
	/*@Bean
	public UserService UserServiceFactory() {
		return new UserServiceImpl();
	}

	*/
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
