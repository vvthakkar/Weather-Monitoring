package io.egen.SpringBootREST.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import io.egen.SpringBootREST.entity.City;


public interface CityRepository extends Repository<City, String> {

	public List<City> findByCity(String city);
	
	public List<City> findAll();
	
	public City save(City city);
	
	public List<City> findByCityOrderByTimestampDesc(String city);
	
	
}
