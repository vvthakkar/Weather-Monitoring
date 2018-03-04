package io.egen.SpringBootREST.repository;


import org.springframework.data.repository.CrudRepository;

import io.egen.SpringBootREST.entity.Wind;

public interface WindRepository extends CrudRepository<Wind, String> {
	
}
