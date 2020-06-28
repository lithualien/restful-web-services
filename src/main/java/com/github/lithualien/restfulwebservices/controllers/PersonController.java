package com.github.lithualien.restfulwebservices.controllers;

import com.github.lithualien.restfulwebservices.models.vo.v1.PersonVO;
import com.github.lithualien.restfulwebservices.services.PersonService;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/persons/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO findById(@PathVariable("id") String id) {
        PersonVO entity = personService.findById(id);
        entity.add(
                linkTo(methodOn(PersonController.class).findById(id)).withSelfRel()
        );
        return entity;
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public Set<PersonVO> all() {
        Set<PersonVO> entitySet = personService.all();
        entitySet
                .forEach(e ->
                        e.add(
                                linkTo(methodOn(PersonController.class).findById(e.getKey() + "")).withSelfRel()
                        )
                );
        return entitySet;
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO save(@RequestBody PersonVO person) {
        PersonVO entity = personService.save(person);
        entity.add(
                linkTo(methodOn(PersonController.class).findById(entity.getKey() + "")).withSelfRel()
        );
        return entity;
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO entity = personService.update(person);
        entity.add(
                linkTo(methodOn(PersonController.class).findById(person.getKey() + "")).withSelfRel()
        );
        return entity;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") String id) {
        personService.delete(id);
    }
}
