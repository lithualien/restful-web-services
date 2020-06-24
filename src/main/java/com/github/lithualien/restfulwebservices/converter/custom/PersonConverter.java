package com.github.lithualien.restfulwebservices.converter.custom;

import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.v2.PersonVOWithBirthday;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonConverter {

    public PersonVOWithBirthday convertEntityToVO(Person person) {
        return new PersonVOWithBirthday(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAddress(),
                person.getGender(),
                LocalDate.of(1998, 7, 28)
        );
    }

    public Person convertVOToEntity(PersonVOWithBirthday person) {
        return new Person(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAddress(),
                person.getGender()
        );
    }
}
