package com.github.lithualien.restfulwebservices.controllers;

import com.github.lithualien.restfulwebservices.converter.NumberConverter;
import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;
    private final NumberConverter numberConverter;

    public PersonController(PersonService personService, NumberConverter numberConverter) {
        this.personService = personService;
        this.numberConverter = numberConverter;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return personService.findById(numberConverter.stringToLong(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Person> all() {
        return personService.all();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}",
                   consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") String id) {
        personService.delete(numberConverter.stringToLong(id));
    }
}
