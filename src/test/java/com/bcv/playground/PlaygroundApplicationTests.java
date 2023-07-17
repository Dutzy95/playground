package com.bcv.playground;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bcv.playground.repository.entities.Person;
import com.bcv.playground.service.PersonService;

@SpringBootTest
@ActiveProfiles(value = "test")
class PlaygroundApplicationTests {

	@Autowired
	private PersonService personService;
	
	@Test
	void testPerson_findAllByLastName() {
		assertEquals(4, personService.getPersonsByLastName("Bogdan").size());
		personService.savePerson(new Person(null, "Vlad", "Bogdan"));
		assertEquals(5, personService.getPersonsByLastName("Bogdan").size());
	}

}
