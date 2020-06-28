package com.github.lithualien.restfulwebservices.controllers;

import com.github.lithualien.restfulwebservices.models.vo.v1.BookVO;
import com.github.lithualien.restfulwebservices.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/books/v1")
@CrossOrigin
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookVO> findById(@PathVariable("id") String id) {
        BookVO entity = bookService.findById(id);
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        System.out.println(authentication.getCredentials() + " credentials.");
        System.out.println(authentication.getDetails() + " details.");
        System.out.println(authentication.getPrincipal() + " principals.");
        entity.add(
                linkTo(methodOn(BookController.class).findById(id)).withSelfRel()
        );
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<Set<BookVO>> all() {
        Set<BookVO> entitySet = bookService.all();
        entitySet
                .forEach(e -> e.add(
                        linkTo(methodOn(BookController.class).findById(e.getKey() + "")).withSelfRel()
                ));
        return ResponseEntity.ok(entitySet);
    }

    @PostMapping
    public ResponseEntity<BookVO> save(@RequestBody BookVO bookVO) {
        BookVO entity = bookService.save(bookVO);
        entity.add(
                linkTo(methodOn(BookController.class).findById(entity.getKey() + "")).withSelfRel()
        );
        return ResponseEntity.ok(entity);
    }

    @PutMapping
    public ResponseEntity<BookVO> update(@RequestBody BookVO bookVO) {
        BookVO entity = bookService.update(bookVO);
        entity.add(
                linkTo(methodOn(BookController.class).findById(entity.getKey() + "")).withSelfRel()
        );
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") String id) {
        bookService.delete(id);
    }
}
