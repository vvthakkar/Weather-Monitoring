package io.egen.SpringBootREST.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.SpringBootREST.entity.City;
import io.egen.SpringBootREST.services.CityService;

@RestController
public class CityController {

	private CityService service;
	
	public CityController(CityService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/data")
	public City create(@RequestBody City city) {
		return service.create(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/data")
	public List<City> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/data/{city}")
	public City findLatest(@PathVariable("city") String city) {
		return service.findLatest(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/data/{city}/{prop}")
	public int findProperty(@PathVariable("city") String city, @PathVariable("prop") String prop ) {
		return service.findProperty(city, prop);
	}
	
}
