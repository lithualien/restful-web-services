package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.models.vo.v1.PersonVO;

import java.util.Set;

public interface PersonService {

    PersonVO findById(String id);
    Set<PersonVO> all();
    PersonVO save(PersonVO person);
    PersonVO update(PersonVO person);
    void delete(String id);
}
