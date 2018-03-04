package io.egen.SpringBootREST.services;

import java.util.List;

import io.egen.SpringBootREST.entity.City;

public interface CityService {

	public City create(City city);
	
	public List<City> findAll();
	
	public City findLatest(String city);
	
	public int findProperty(String city, String prop);
}
