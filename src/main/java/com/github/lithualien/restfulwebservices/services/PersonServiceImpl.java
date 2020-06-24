package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.exceptions.ResourceNotFoundException;
import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.PersonVO;
import com.github.lithualien.restfulwebservices.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl  {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @Override
//    public PersonVO findById(Long id) {
//        return personRepository.findById(id).<ResourceNotFoundException>orElseThrow(() -> {
//            throw new ResourceNotFoundException("User with id=" + id + " was not found.");
//        });
//    }
//
//    @Override
//    public Set<PersonVO> all() {
//        return StreamSupport
//                .stream(personRepository.findAll().spliterator(), false)
//                .collect(Collectors.toSet());
//    }
//
//    @Override
//    public PersonVO save(PersonVO person) {
//        return personRepository.save(person);
//    }
//
//    @Override
//    public PersonVO update(PersonVO person) {
//        Person entity = findById(person.getId());
//        entity = person;
//        return personRepository.save(entity);
//    }
//
//    @Override
//    public void delete(Long id) {;
//        Person entity = findById(id);
//        personRepository.delete(entity);
//    }
}
