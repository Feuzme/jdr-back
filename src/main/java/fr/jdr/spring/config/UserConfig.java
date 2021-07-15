package fr.jdr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.SimpleUserService;
import fr.jdr.spring.services.UserService;
import fr.jdr.spring.services.servicesimpl.AuthentificationUserServiceImpl;
import fr.jdr.spring.services.servicesimpl.ModificationUserServiceImpl;
import fr.jdr.spring.services.servicesimpl.SimpleUserServiceImpl;
import fr.jdr.spring.services.servicesimpl.UserServiceImpl;



@Configuration
public class UserConfig {
/**
 
	@Bean
	public ObjectMapper objectMapper() {
		/*return new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		*/
/*		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		return mapper;
	}
	*/
	
	
	
	@Bean
	public UserService userService(UserRepository repository, ObjectMapper mapper) {
		return new UserServiceImpl(repository, mapper);
	}
	
	@Bean
	public AuthentificationUserServiceImpl authService(UserRepository repository) {
		return new AuthentificationUserServiceImpl(repository);
	}
	
	@Bean
	public ModificationUserServiceImpl modificationUtilisateurServiceImpl(
			ObjectMapper mapper, 
			UserRepository repository, UserService service) {
		return new ModificationUserServiceImpl(mapper, repository, service);
	}
	
	@Bean
	public SimpleUserService simpleUserService(ObjectMapper mapper, UserRepository repository) {
		return new SimpleUserServiceImpl(mapper, repository);
	}
	
	
	
}
