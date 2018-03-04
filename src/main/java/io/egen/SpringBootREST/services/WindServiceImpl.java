package io.egen.SpringBootREST.services;

import org.springframework.stereotype.Service;

import io.egen.SpringBootREST.entity.Wind;
import io.egen.SpringBootREST.repository.WindRepository;

@Service
public class WindServiceImpl implements WindService{

	private WindRepository repository;
	
	public WindServiceImpl(WindRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Wind create(Wind wind) {
		return repository.save(wind);
	}

}
