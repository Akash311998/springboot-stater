package com.contoller;

import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.IPersonService;

@RestController
public class RequestController {

	@Autowired
	IPersonService personService;

	@GetMapping("/")
	public ResponseEntity<Object> dummy() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/addPerson")
	public ResponseEntity<Object> addStudent(@RequestBody Person person) throws Exception {
		if (!validatePerson(person)) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		personService.addPerson(person);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private boolean validatePerson(Person person) {
		if (ObjectUtils.isEmpty(person) || StringUtils.isNullOrEmpty(person.getFirstName())
				|| StringUtils.isNullOrEmpty(person.getLastName())) {
			return false;
		}
		return true;
	}

	@GetMapping("/getAllPerson")
	public ResponseEntity<List<Person>> getAllStudent() {
		return new ResponseEntity<List<Person>>(personService.getAllPersons(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePerson")
	public ResponseEntity<Object> deletePerson(@RequestParam("id") Short id) throws Exception{
		personService.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person) throws Exception{
		personService.updatePerson(person);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
