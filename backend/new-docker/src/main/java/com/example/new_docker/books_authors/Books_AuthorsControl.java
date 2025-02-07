package com.example.new_docker.books_authors;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Books_AuthorsControl {

    private final Books_AuthorsService service;

    public Books_AuthorsControl(Books_AuthorsService service) {
        this.service = service;
    }

    @GetMapping("/books_authors")
    public List<Books_AuthorsDto> findAllBooks_Authors(){
        return service.findAllBooks_Authors();
    }

    @PostMapping("/books_authors")
    public Books_AuthorsDto saveBooks_Authors(
            @RequestBody Books_AuthorsDto dto
    ){
        return service.saveBooks_Authors(dto);
    }
    @GetMapping("/books_authors/{books-id}/{authors-id}")
    public Books_AuthorsDto findBooks_AuthorsById(
            @PathVariable("books-id") int books_id,
            @PathVariable("authors-id") int authors_id
    ){
        return service.findBooks_AuthorsById(books_id,authors_id);
    }
    @DeleteMapping("/books_authors/{books-id}/{authors-id}")
    public void deleteBooks_AuthorsById(
            @PathVariable("books-id") int books_id,
            @PathVariable("authors-id") int authors_id
    ){
        service.deleteBooks_AuthorsById(books_id,authors_id);
    }


}
