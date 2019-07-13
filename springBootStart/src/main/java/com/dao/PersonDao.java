package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jparepository.personrepository;
import com.model.Person;

@Component
public class PersonDao implements IPersonDao{
	
	@Autowired
	personrepository personRepo ;

	@Override
	public List<Person> getAllPersons() {
		List<Person> list = new ArrayList<>();
	    personRepo.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Optional<Person> findById(Short id){
		return personRepo.findById(id);
	}

	@Override
	public Person addPerson(Person person) {
		personRepo.save(person);
		return person;
	}

	@Override
	public void deletePerson(Short id) {
		personRepo.deleteById(id);
	}

	@Override
	public void updatePerson(Person person) {
		personRepo.save(person);
		
	}



}
