package com.github.lithualien.restfulwebservices.models.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
public class PersonVO implements Serializable {

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String gender;
}
