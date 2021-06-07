package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.Session;
import fr.jdr.spring.repositories.SessionRepository;
import fr.jdr.spring.services.GenericService;

public class SessionServiceImpl implements GenericService<Session> {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public List<Session> getAll() {
		return this.sessionRepository.findAll();
	}

	@Override
	public Session getById(String id) {
		return this.sessionRepository.findById(id).get();
	}

	@Override
	public Session create(Session session) {
		return this.sessionRepository.save(session);
	}

	@Override
	public Session update(Session session) {
		return this.sessionRepository.save(session);
	}

	@Override
	public void delete(Session session) {
		this.sessionRepository.delete(session);	
	}
}
