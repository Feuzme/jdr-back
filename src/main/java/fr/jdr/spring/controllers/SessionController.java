package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.Session;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("sessions")
public class SessionController {
	
	@Autowired
	private GenericService<Session> sessionService;
	
	@GetMapping()
	public List<Session> getAll(){
		return this.sessionService.getAll();
	}
	
	@GetMapping("{id}")
	public Session getById(@PathVariable String id) {
		return this.sessionService.getById(id);
	}
	
	@PostMapping()
	public Session create(@RequestBody Session session) {
		return this.sessionService.create(session);
	}
	
	@PatchMapping()
	public Session update(@RequestBody Session session) {
		return this.sessionService.update(session);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Session session) {
		this.sessionService.delete(session);
	}
}
