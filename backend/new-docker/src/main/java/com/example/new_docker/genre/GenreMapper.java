package com.example.new_docker.genre;

import org.springframework.stereotype.Service;

@Service
public class GenreMapper {
    public GenreDto toGenreDto(Genre genre){
        return new GenreDto(genre.getName(),genre.getDescription());
    }
    public Genre toGenre(GenreDto dto){
        return new Genre(dto.name(), dto.description());
    }
}
