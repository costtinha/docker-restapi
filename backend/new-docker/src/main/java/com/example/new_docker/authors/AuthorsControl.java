package com.example.new_docker.authors;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@NamedQueries({
        @NamedQuery(name = "Authors.findAllByName", query = "SELECT a FROM Authors a WHERE a.name = :name "),
        @NamedQuery(name ="Authors.findAllTest", query = "SELECT a FROM Authors a" )
}
)
@RestController
@RequestMapping("/authors")
public class AuthorsControl {
    private final AuthorsService service;

    public AuthorsControl(AuthorsService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorsDto> findAllAuthors(){
        return service.findAllAuthors();
    }
    @PostMapping()
    public AuthorsDto saveAuthors(@RequestBody AuthorsDto dto){
        return service.saveAuthors(dto);
    }
    @GetMapping("/{authors-id}")
    public AuthorsDto findAuthorsById(
            @PathVariable("authors-id") int id
            ){
        return service.findAuthorsById(id);
    }

    @GetMapping("/search/{authors-name}")
    public List<AuthorsDto> findAuthorsByName(
            @PathVariable("authors-name") String name
    ){
        return service.findAuthorsByName(name);
    }
    @GetMapping("/authors-test")
    public List<AuthorsDto> findAllAuthorsTest(){
        return service.findAllAuthorsNamedQuery();
    }

    @DeleteMapping("/{authors-id}")
    public void deleteAuthorsById(
            @PathVariable("authors-id") int id
    ){
        service.deleteAuthorsById(id);
    }

}
