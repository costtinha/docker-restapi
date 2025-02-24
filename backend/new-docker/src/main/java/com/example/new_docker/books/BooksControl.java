package com.example.new_docker.books;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NamedQueries(
        {
                @NamedQuery(name = "Books.findBooksByTitle", query = "SELECT b FROM Books b WHERE b.title = :title")
        }
)
@RequestMapping("/books")
public class BooksControl {
    private final BooksService service;

    public BooksControl(BooksService service) {
        this.service = service;
    }

    @GetMapping()
    public List<BooksDto> findAllBooks(){
        return service.findAllBooks();
    }
    @PostMapping()
    public BooksDto saveBook(
            @RequestBody BooksDto dto
    ){
        return service.saveBook(dto);
    }

    @GetMapping("/{books-id}")
    public BooksDto findBookById(
            @PathVariable("books-id") int id
    ){
        return service.findBookById(id);
    }
    @GetMapping("/search/{books-title")
    public List<BooksDto> findBooksByTitle(
            @PathVariable("books-title") String title
    ){
        return service.findBooksByTitle(title);
    }

    @DeleteMapping("/{books-id}")
    public void deleteBookById(
            @PathVariable("books-id") int id
    ){
         service.deleteBookById(id);
    }
}
