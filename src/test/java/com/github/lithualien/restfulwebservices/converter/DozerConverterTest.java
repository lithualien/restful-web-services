package com.github.lithualien.restfulwebservices.converter;

import com.github.lithualien.restfulwebservices.mocks.MockPerson;
import com.github.lithualien.restfulwebservices.models.Person;
import com.github.lithualien.restfulwebservices.models.vo.PersonVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class DozerConverterTest {

    private MockPerson mockPerson;

    @BeforeEach
    void setUp() {
        mockPerson = new MockPerson();
    }

    @AfterEach
    void tearDown() {
        mockPerson = null;
    }

    @Test
    void parseEntityToVO() {
        PersonVO output = DozerConverter.parseObject(
                mockPerson.mockPerson(),
                PersonVO.class
        );
        assertEquals(output, mockPerson.mockPersonVO());
    }

    @Test
    void parseSetToVO() {
        Set<PersonVO> output = DozerConverter.parseSets(
                mockPerson.personSet(),
                PersonVO.class
        );
        assertIterableEquals(output, mockPerson.personVOSet());
    }

    @Test
    void parseVOToEntity() {
        Person output = DozerConverter.parseObject(
                mockPerson.mockPersonVO(),
                Person.class
        );
        assertEquals(output, mockPerson.mockPerson());
    }

    @Test
    void parseVOToSet() {
        Set<Person> output = DozerConverter.parseSets(
                mockPerson.personVOSet(),
                Person.class
        );
        assertIterableEquals(output, mockPerson.personSet());
    }
}