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
import fr.jdr.spring.repositories.GameSheetRepository;
import fr.jdr.spring.repositories.ModelSheetRepo;
import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.Session;
import fr.jdr.spring.services.GameSheetService;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.ModelSheetService;
import fr.jdr.spring.services.servicesimpl.ComposantEditImpl;
import fr.jdr.spring.services.servicesimpl.ComposantStandardImpl;
import fr.jdr.spring.services.servicesimpl.CreneauServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameSheetServiceImpl;
import fr.jdr.spring.services.servicesimpl.ModelSheetServiceImpl;
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
	
	@Bean
	public UserService UserServiceFactory() {
		return new UserServiceImpl();
	}

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
	
	@Bean
	public GameSheetService gameSheetServiceFactory(GameSheetRepository repo, ObjectMapper mapper) {
		return new GameSheetServiceImpl(repo, mapper);
	}
	
	@Bean
	public ModelSheetService modelSheetServiceFactory(ModelSheetRepo repo, ObjectMapper mapper) {
		return new ModelSheetServiceImpl(repo, mapper);
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	}
}
