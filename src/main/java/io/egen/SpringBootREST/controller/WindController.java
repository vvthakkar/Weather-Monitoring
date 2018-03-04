package io.egen.SpringBootREST.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.SpringBootREST.entity.Wind;
import io.egen.SpringBootREST.services.WindService;

@RestController
public class WindController {

	private WindService service;
	
	public WindController(WindService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/winds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Wind create(@RequestBody Wind wind) {
		return service.create(wind);
	}
}
