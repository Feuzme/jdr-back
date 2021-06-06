package fr.jdr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.jdr.spring.models.ComposantEdit;
import fr.jdr.spring.models.ComposantStandard;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.servicesimpl.ComposantEditImpl;
import fr.jdr.spring.services.servicesimpl.ComposantStandardImpl;


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
}
