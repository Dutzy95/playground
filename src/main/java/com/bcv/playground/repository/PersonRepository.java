package com.bcv.playground.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcv.playground.repository.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>  {

	List<Person> findByLastName(String lastName);
}
