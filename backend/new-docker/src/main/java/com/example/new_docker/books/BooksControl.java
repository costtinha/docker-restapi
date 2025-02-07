package com.example.new_docker.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksControl {
    private final BooksService service;

    public BooksControl(BooksService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<BooksDto> findAllBooks(){
        return service.findAllBooks();
    }
    @PostMapping("/books")
    public BooksDto saveBook(
            @RequestBody BooksDto dto
    ){
        return service.saveBook(dto);
    }

    @GetMapping("/books/{books-id}")
    public BooksDto findBookById(
            @PathVariable("books-id") int id
    ){
        return service.findBookById(id);
    }

    @DeleteMapping("/books/{books-id}")
    public void deleteBookById(
            @PathVariable("books-id") int id
    ){
         service.deleteBookById(id);
    }
}
