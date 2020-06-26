package com.github.lithualien.restfulwebservices.models.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String author;

    @JsonProperty("launch_date")
    private LocalDate launchDate;

    private Float price;
    private String title;
}
