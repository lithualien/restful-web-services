package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.converter.DozerConverter;
import com.github.lithualien.restfulwebservices.converter.custom.PersonConverter;
import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.v2.PersonVOWithBirthday;
import com.github.lithualien.restfulwebservices.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceWithBirthday {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    public PersonServiceWithBirthday(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    public PersonVOWithBirthday saveWithBirthday(PersonVOWithBirthday person) {
        Person entity =personConverter.convertVOToEntity(person);
        person = personConverter.convertEntityToVO(personRepository.save(entity));
        return person;
    }
}
