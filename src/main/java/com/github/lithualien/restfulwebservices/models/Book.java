package com.github.lithualien.restfulwebservices.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;

    @Column(name="launch_date")
    private LocalDate launchDate;

    private Float price;
    private String title;
}
