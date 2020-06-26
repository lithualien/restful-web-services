package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.models.vo.v1.BookVO;

import java.util.Set;

public interface BookService {

    BookVO findById(String id);
    Set<BookVO> all();
    BookVO save(BookVO bookVO);
    BookVO update(BookVO bookVO);
    void delete(String id);

}
