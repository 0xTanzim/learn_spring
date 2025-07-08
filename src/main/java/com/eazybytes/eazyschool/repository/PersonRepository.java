package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer > {
}
