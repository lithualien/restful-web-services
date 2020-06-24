package com.github.lithualien.restfulwebservices.controllers;

import com.github.lithualien.restfulwebservices.converter.NumberConverter;
import com.github.lithualien.restfulwebservices.models.vo.v1.PersonVO;
import com.github.lithualien.restfulwebservices.services.PersonService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/persons/v1")
public class PersonController {

    private final PersonService personService;
    private final NumberConverter numberConverter;

    public PersonController(PersonService personService, NumberConverter numberConverter) {
        this.personService = personService;
        this.numberConverter = numberConverter;
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO findById(@PathVariable("id") String id) {
        return personService.findById(numberConverter.stringToLong(id));
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public Set<PersonVO> all() {
        return personService.all();
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO save(@RequestBody PersonVO person) {
        return personService.save(person);
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO update(@RequestBody PersonVO person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        personService.delete(numberConverter.stringToLong(id));
    }
}
