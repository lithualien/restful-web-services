package com.github.lithualien.restfulwebservices.models.vo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PersonVO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PersonVO)) return false;
//        PersonVO personVO = (PersonVO) o;
//        return Objects.equals(id, personVO.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
