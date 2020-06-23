package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.models.Person;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person findById(Long id) {
        return new Person(1L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male");
    }

    @Override
    public Set<Person> all() {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person(1L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        persons.add(new Person(2L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        persons.add(new Person(3L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        persons.add(new Person(4L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        persons.add(new Person(5L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        persons.add(new Person(6L, "Tomas", "Dominauskas", "Tiesos g. 18", "Male"));
        return persons;
    }

    @Override
    public Person create(Person person) {
        return person;
    }

    @Override
    public Person update(Person person) {
        return person;
    }

    @Override
    public void delete(Long id) {
    }
}
