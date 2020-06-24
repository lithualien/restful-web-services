package com.github.lithualien.restfulwebservices.mocks;

import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.v1.PersonVO;

import java.util.HashSet;
import java.util.Set;

public class MockPerson {

    public Person mockPerson() {
        return mockPerson(0);
    }

    public PersonVO mockPersonVO() {
        return mockPersonVO(0);
    }

    public Set<Person> personSet() {
        Set<Person> persons = new HashSet<>();
        for(int i = 0; i < 14; i++) {
            persons.add(mockPerson(i));
        }
        return persons;
    }

    public Set<PersonVO> personVOSet() {
        Set<PersonVO> persons = new HashSet<>();
        for(int i = 0; i < 14; i++) {
            persons.add(mockPersonVO(i));
        }
        return persons;
    }

    private Person mockPerson(Integer number) {
        return new Person(
                number.longValue(),
                "First" + number,
                "Last" + number,
                "Address, Street " + number,
                (number % 2) == 0 ? "Male" : "Female"
        );
    }

    private PersonVO mockPersonVO(Integer number) {
        return new PersonVO(
                number.longValue(),
                "First" + number,
                "Last" + number,
                "Address, Street " + number,
                (number % 2) == 0 ? "Male" : "Female"
        );
    }

}
