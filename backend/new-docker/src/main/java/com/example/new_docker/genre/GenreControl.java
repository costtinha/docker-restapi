package com.example.new_docker.genre;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NamedQueries(
        {
                @NamedQuery(name = "Genre.findGenreByName", query = ("SELECT g FROM Genre g WHERE g.name = :name"))
        }
)
@RequestMapping("/genre")
public class GenreControl {
    private final GenreService service;

    public GenreControl(GenreService service) {
        this.service = service;
    }

    @GetMapping()
    public List<GenreDto> findAllGenre(
    ){
        return service.findAll();
    }

    @PostMapping()
    public GenreDto saveGenre(
            @RequestBody GenreDto dto
            ){
        return service.saveGenre(dto);
    }
    @GetMapping("/{genre-id}")
    public GenreDto findGenreById(
            @PathVariable("genre-id") int id
    ){
        return service.findGenreById(id);
    }

    @GetMapping("/search/{genre-name}")
    public List<GenreDto> findGenreByName(
            @PathVariable("genre-name") String name
    ){
        return service.findGenreByName(name);
    }

    @DeleteMapping("/{genre-id}")
    public void deleteGenreById(
            @PathVariable("genre-id") int id
    ){
        service.deleteGenreById(id);
    }
}
