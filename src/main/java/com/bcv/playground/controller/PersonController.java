package com.bcv.playground.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping(value = "/save")
	@ResponseBody
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping(value = "/allByLastname/{lastname}")
	@ResponseBody
	public List<Person> getPersonByLastName(
			@PathVariable("lastname") String lastname) {
		return personService.getPersonsByLastName(lastname);
	}
	
	@GetMapping(value = "/all")
	@ResponseBody
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
}
