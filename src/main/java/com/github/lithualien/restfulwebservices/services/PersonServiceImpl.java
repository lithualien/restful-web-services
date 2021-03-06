package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.converter.DozerConverter;
import com.github.lithualien.restfulwebservices.converter.NumberConverter;
import com.github.lithualien.restfulwebservices.exceptions.ResourceNotFoundException;
import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.v1.PersonVO;
import com.github.lithualien.restfulwebservices.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final NumberConverter numberConverter;

    public PersonServiceImpl(PersonRepository personRepository, NumberConverter numberConverter) {
        this.personRepository = personRepository;
        this.numberConverter = numberConverter;
    }

    @Override
    public PersonVO findById(String id) {
        return DozerConverter
                .parseObject(
                    personRepository
                        .findById(numberConverter.stringToLong(id))
                        .<ResourceNotFoundException>orElseThrow(() -> {
                            throw new ResourceNotFoundException("User with id=" + id + " was not found.");
                        }), PersonVO.class
        );
    }

    @Override
    public Set<PersonVO> all() {
        return DozerConverter.parseSet(
                StreamSupport
                .stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet()), PersonVO.class);
    }

    @Override
    public PersonVO save(PersonVO person) {
        Person entity = DozerConverter.parseObject(person, Person.class);
        person = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return person;
    }

    @Override
    public PersonVO update(PersonVO person) {
        findById(person.getKey() + ""); // it is better to rewrite (duplicate code) or to reuse the code and not refer the result, to throw Resource not found exception
        Person entity = DozerConverter.parseObject(person, Person.class);
        person = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return person;
    }

    @Override
    public void delete(String id) {
        Person entity = DozerConverter.parseObject(findById(id), Person.class);
        personRepository.delete(entity);
    }
}
