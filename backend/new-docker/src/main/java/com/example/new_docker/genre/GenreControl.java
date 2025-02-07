package com.example.new_docker.genre;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreControl {
    private final GenreService service;

    public GenreControl(GenreService service) {
        this.service = service;
    }

    @GetMapping("/genre")
    public List<GenreDto> findAllGenre(
    ){
        return service.findAll();
    }

    @PostMapping("/genre")
    public GenreDto saveGenre(
            @RequestBody GenreDto dto
            ){
        return service.saveGenre(dto);
    }
    @GetMapping("/genre/{genre-id}")
    public GenreDto findGenreById(
            @PathVariable("genre-id") int id
    ){
        return service.findGenreById(id);
    }
    @DeleteMapping("/genre/{genre-id}")
    public void deleteGenreById(
            @PathVariable("genre-id") int id
    ){
        service.deleteGenreById(id);
    }
}
