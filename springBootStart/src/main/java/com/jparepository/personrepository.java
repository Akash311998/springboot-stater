package com.jparepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Person;

@Repository
public interface personrepository extends  CrudRepository<Person,Short>{

}
