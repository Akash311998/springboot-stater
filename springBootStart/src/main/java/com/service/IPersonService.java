package com.service;

import java.util.List;

import com.model.Person;

public interface IPersonService {
	
	public List<Person> getAllPersons();
	
	public Person addPerson(Person person) throws Exception;

	public Person deletePerson(Short id) throws Exception;

	public Person updatePerson(Person person) throws Exception ;


}
