package com.github.lithualien.restfulwebservices.repository;

import com.github.lithualien.restfulwebservices.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
