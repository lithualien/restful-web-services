package com.github.lithualien.restfulwebservices.models.vo.v2;

import com.github.lithualien.restfulwebservices.models.vo.PersonVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class PersonVOWithBirthday extends PersonVO {

    private LocalDate birthday;

    public PersonVOWithBirthday(Long id, String firstName, String lastName,
                                String address, String gender, LocalDate birthday) {
        super(id, firstName, lastName, address, gender);
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVOWithBirthday)) return false;
        if (!super.equals(o)) return false;
        PersonVOWithBirthday that = (PersonVOWithBirthday) o;
        return Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthday);
    }
}
