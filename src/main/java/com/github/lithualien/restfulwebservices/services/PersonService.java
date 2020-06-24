package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.PersonVO;

import java.util.Set;

public interface PersonService {

    PersonVO findById(Long id);
    Set<PersonVO> all();
    PersonVO save(PersonVO person);
    PersonVO update(PersonVO person);
    void delete(Long id);
}
