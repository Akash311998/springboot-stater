package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IPersonDao;
import com.model.Person;

@Service
public class PersonService implements IPersonService {

	@Autowired
	IPersonDao personDao  ;

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDao.getAllPersons();
	}

	@Override
	public Person addPerson(Person person) throws Exception {
		Optional<Person> optional = personDao.findById(person.getId());
		if(!optional.isPresent()){
			 personDao.addPerson(person);
			 return person;
		}
		throw new Exception("Student Already Exists");
	}
	
	@Override
	public Person deletePerson(Short id) throws Exception{
		if(personDao.findById(id).isPresent()){
			personDao.deletePerson(id);
			return new Person();
		}
		throw new Exception("Person Not Exists");
	}

	@Override
	public Person updatePerson(Person person) throws Exception {
		if(personDao.findById(person.getId()).isPresent()){
			personDao.updatePerson(person);
			return person;
		}
		throw new Exception("Person Not Exists");
	}
	


}
