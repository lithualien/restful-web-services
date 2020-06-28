package com.github.lithualien.restfulwebservices.repository;

import com.github.lithualien.restfulwebservices.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<User, Long> {

    @Query("select user from User user where user.userName = :userName")
    User findByUsername(@Param("userName") String username);
}
