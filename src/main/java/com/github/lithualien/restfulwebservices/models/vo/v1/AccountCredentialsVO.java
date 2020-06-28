package com.github.lithualien.restfulwebservices.models.vo.v1;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountCredentialsVO  implements Serializable {

    private String username;
    private String password;

}
