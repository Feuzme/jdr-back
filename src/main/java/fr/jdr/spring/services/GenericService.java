package fr.jdr.spring.services;

import java.util.List;

public interface GenericService<T> {
	
	 List<T> getAll() ;
		
	 T getById(Long id);
	
	 T create(T t);
	
	 T update(T t);
	
	 void delete(Long id);


}
