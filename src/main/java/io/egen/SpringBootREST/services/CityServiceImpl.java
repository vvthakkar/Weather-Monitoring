package io.egen.SpringBootREST.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.SpringBootREST.entity.City;
import io.egen.SpringBootREST.exceptions.BadRequestException;
import io.egen.SpringBootREST.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

	private CityRepository repository;
	private WindService service;
	
	public CityServiceImpl(CityRepository repository, WindService service) {
		this.repository = repository;
		this.service = service;
	}
	@Override
	@Transactional
	public City create(City city) {
		city.setWind(service.create(city.getWind()));
		return repository.save(city);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findAll() {

		List<City> cities = new ArrayList<City>();
		repository.findAll().forEach(cities::add);
		return cities;
	}
	
	@Override
	@Transactional(readOnly = true)
	public City findLatest(String city) {
		
		List<City> exist = repository.findByCity(city);
		if(exist.isEmpty()) {
			throw new BadRequestException("City "+ city + " is not Exist");
			//Throw a runtime exceptions here which should return 400 to client Bad request
		}
		
		List<City> cities = new ArrayList<City>();
		repository.findByCityOrderByTimestampDesc(city).forEach(cities::add);
		return cities.get(0);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int findProperty(String city, String prop) {
		City c = findLatest(city);
		
		if(prop.equals("humidity"))
			return c.getHumidity();
		
		else if(prop.equals("pressure"))
			return c.getPressure();
		
		else if(prop.equals("temperature"))
			return c.getTemperature();
		
		else
		 return 0;
	}
	
	

	
}
