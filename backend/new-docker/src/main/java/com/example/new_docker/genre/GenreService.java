package com.example.new_docker.genre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreMapper mapper;
    private final GenreRepository repository;

    public GenreService(GenreMapper mapper, GenreRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<GenreDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toGenreDto)
                .collect(Collectors.toList());
    }

    public GenreDto saveGenre(GenreDto dto){
       return mapper.toGenreDto(repository.save(mapper.toGenre(dto)));
    }

    public GenreDto findGenreById(int id){
        return mapper.toGenreDto(repository.findById(id).orElse(null));
    }
    public void deleteGenreById(int id){
        repository.deleteById(id);
    }

}
