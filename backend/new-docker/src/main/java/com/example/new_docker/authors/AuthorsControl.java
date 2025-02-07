package com.example.new_docker.authors;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorsControl {
    private final AuthorsService service;

    public AuthorsControl(AuthorsService service) {
        this.service = service;
    }

    @GetMapping("/authors")
    public List<AuthorsDto> findAllAuthors(){
        return service.findAllAuthors();
    }
    @PostMapping("/authors")
    public AuthorsDto saveAuthors(@RequestBody AuthorsDto dto){
        return service.saveAuthors(dto);
    }
    @GetMapping("/authors/{authors-id}")
    public AuthorsDto findAuthorsById(
            @PathVariable("authors-id") int id
            ){
        return service.findAuthorsById(id);
    }
    @DeleteMapping("/authors/{authors-id}")
    public void deleteAuthorsById(
            @PathVariable("authors-id") int id
    ){
        service.deleteAuthorsById(id);
    }

}
