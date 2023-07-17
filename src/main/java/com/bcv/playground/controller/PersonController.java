package com.bcv.playground.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcv.playground.repository.entities.Person;
import com.bcv.playground.service.PersonService;

@RestController
@RequestMapping(value="/persons")
public class PersonController {

	private PersonService personService;
	
	protected PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	@ResponseBody
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
}
