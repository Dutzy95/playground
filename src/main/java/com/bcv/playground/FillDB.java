package com.bcv.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bcv.playground.repository.PersonRepository;
import com.bcv.playground.repository.entities.Person;

import jakarta.annotation.PostConstruct;

@Component
public class FillDB {
	
	private Logger logger = LoggerFactory.getLogger(FillDB.class);
	
	@Value(value = "${spring.jpa.hibernate.ddl-auto}")
	private String ddlAuto;
	
	private PersonRepository personRepository;
	
	protected FillDB(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@PostConstruct
	public void initDB() {
		if (ddlAuto.startsWith("create")) {
			logger.info("spring.jpa.hibernate.ddl-auto = '" + ddlAuto + "'");
			logger.info("========================== Filling database with data ==========================");
		
			for (int i = 1; i <= 5; i++) {
				Person person = new Person(null, "firstName" + i, "lastName" + i);
				logger.info("Inserting Person: " + person);
				personRepository.save(person);
			}
			
			logger.info("=================================================================================");
		}
	}

}
