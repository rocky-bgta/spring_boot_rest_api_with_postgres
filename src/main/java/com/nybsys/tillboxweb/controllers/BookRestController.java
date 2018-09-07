package com.nybsys.tillboxweb.controllers;


import com.nybsys.tillboxweb.constant.AccountModuleConstant;
import com.nybsys.tillboxweb.domain.Book;
import com.nybsys.tillboxweb.domain.BookRepository;
import com.nybsys.tillboxweb.models.accounting.AccountModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@RestController
@RequestMapping("/api/books")
@Api(tags = "Book Controller")
public class BookRestController {

    private BookRepository repository;

    @Inject
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(repository.save(book), HttpStatus.CREATED);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Book> getBookWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Book>> findBookWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBookFromDB(@PathVariable("id") long id, @RequestBody Book book) {

        Book currentBook = repository.findOne(id);
        currentBook.setName(book.getName());
        //currentBook.setDescription(book.getDescription());

        return new ResponseEntity<>(repository.save(currentBook), HttpStatus.OK);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteBookWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @ApiOperation(value = "", response = Book.class)
    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        repository.deleteAll();
    }
}
