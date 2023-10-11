package com.bcv.playground.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcv.playground.repository.PersonRepository;
import com.bcv.playground.repository.entities.Person;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	protected PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> getPersonsByLastName(String lastName) {
		return personRepository.findByLastName(lastName);
	}
	
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}
}
