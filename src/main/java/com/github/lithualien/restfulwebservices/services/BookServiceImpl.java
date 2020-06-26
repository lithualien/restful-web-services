package com.github.lithualien.restfulwebservices.services;

import com.github.lithualien.restfulwebservices.converter.DozerConverter;
import com.github.lithualien.restfulwebservices.converter.NumberConverter;
import com.github.lithualien.restfulwebservices.exceptions.ResourceNotFoundException;
import com.github.lithualien.restfulwebservices.models.Book;
import com.github.lithualien.restfulwebservices.models.vo.v1.BookVO;
import com.github.lithualien.restfulwebservices.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final NumberConverter numberConverter;

    public BookServiceImpl(BookRepository bookRepository, NumberConverter numberConverter) {
        this.bookRepository = bookRepository;
        this.numberConverter = numberConverter;
    }

    @Override
    public BookVO findById(String id) {
        return DozerConverter
                .parseObject(
                        bookRepository
                            .findById(numberConverter.stringToLong(id))
                            .<ResourceNotFoundException>orElseThrow(() -> {
                                throw new ResourceNotFoundException("Book with id=" + id + " was not found.");
                            }), BookVO.class
                );
    }

    @Override
    public Set<BookVO> all() {
        return DozerConverter
                .parseSet(
                        StreamSupport
                            .stream(bookRepository.findAll().spliterator(), false)
                            .collect(Collectors.toSet()), BookVO.class
                );
    }

    @Override
    public BookVO save(BookVO bookVO) {
        Book entity = DozerConverter.parseObject(bookVO, Book.class);
        return DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
    }

    @Override
    public BookVO update(BookVO bookVO) {
        findById(bookVO.getKey() + "");
        Book entity = DozerConverter.parseObject(bookVO, Book.class);
        return DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
    }

    @Override
    public void delete(String id) {
        Book entity = DozerConverter.parseObject(findById(id), Book.class);
        bookRepository.delete(entity);
    }
}
