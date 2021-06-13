package fr.jdr.spring.services;

import java.util.List;

public interface GenericService<T> {

	/**
	 * List all the entity entity in database
	 * @return
	 */
	public List<T> getAll();
	
	/**
	 * Retrieve an entity via his ID
	 * @param id the id of the entity we want to retrieve
	 * @return
	 */
	public T getById(String id);
	
	/**
	 * insert new entity in the database	
	 * @param entity the entity to save
	 * @return
	 */
	public T create(T entity);
	
	/**
	 * update some parameters of a database entity
	 * @param entity contains the data we want to modify and must contain the id of the entity we want to update
	 * @return
	 */
	public T update(T entity);
	
	/**
	 * delete a database entity
	 * @param entity must contains the id of the entity we want to suppress 
	 */
	public void delete(T entity);
}
