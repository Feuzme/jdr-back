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
import fr.jdr.spring.models.BasePluginEdit;
import fr.jdr.spring.models.BasePlugin;
import fr.jdr.spring.repositories.GameSheetRepository;
import fr.jdr.spring.repositories.ModelSheetRepository;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.GameSheet;
import fr.jdr.spring.models.GameType;
import fr.jdr.spring.models.ModelSheet;
import fr.jdr.spring.models.Session;
import fr.jdr.spring.services.GameSheetService;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.ModelSheetService;
import fr.jdr.spring.services.servicesimpl.BasePluginEditImpl;
import fr.jdr.spring.services.servicesimpl.BasePluginImpl;
import fr.jdr.spring.services.servicesimpl.CreneauServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameSheetServiceImpl;
import fr.jdr.spring.services.servicesimpl.GameTypeServiceImpl;
import fr.jdr.spring.services.servicesimpl.ModelSheetServiceImpl;
import fr.jdr.spring.services.servicesimpl.SessionServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public GenericService<BasePlugin> composantStandardServiceFactory() {
		return new BasePluginImpl();
	}
	
	@Bean
	public GenericService<BasePluginEdit> composantEditServiceFactory() {
		return new BasePluginEditImpl();
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
	
	@Bean
	public GenericService<GameSheet> gameSheetServiceFactory() {
		return new GameSheetServiceImpl();
	}
	
	@Bean
	public GenericService<ModelSheet> modelSheetServiceFactory() {
		return new ModelSheetServiceImpl();
	}
	
	@Bean
	public GenericService<GameType> gameTypefactory() {
		return new GameTypeServiceImpl();
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	}
	

	
}
