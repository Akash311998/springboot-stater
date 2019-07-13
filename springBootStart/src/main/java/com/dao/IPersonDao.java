package com.dao;

import java.util.List;
import java.util.Optional;

import com.model.Person;

public interface IPersonDao {

	public List<Person> getAllPersons();

	public Person addPerson(Person person);

	public Optional<Person> findById(Short id);

	public void deletePerson(Short id);

	public void updatePerson(Person person);

}
