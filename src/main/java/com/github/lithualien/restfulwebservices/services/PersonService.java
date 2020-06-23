package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.models.Person;

import java.util.Set;

public interface PersonService {

    Person findById(Long id);
    Set<Person> all();
    Person create(Person person);
    Person update(Person person);
    void delete(Long id);
}
