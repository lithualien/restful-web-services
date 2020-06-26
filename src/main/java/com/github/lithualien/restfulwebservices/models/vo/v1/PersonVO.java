package com.github.lithualien.restfulwebservices.models.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String address;
    private String gender;
}
