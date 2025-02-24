package com.example.new_docker.authors;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorsService {
    private final AuthorsMapper mapper;
    private final AuthorsRepository repository;

    public AuthorsService(AuthorsMapper mapper, AuthorsRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    public List<AuthorsDto> findAllAuthors() {
        return repository.findAll()
                .stream()
                .map(mapper::toAuthorsDto)
                .collect(Collectors.toList());
    }

    public AuthorsDto saveAuthors(AuthorsDto dto) {
        return mapper.toAuthorsDto(repository.save(mapper.toAuthors(dto)));
    }

    public AuthorsDto findAuthorsById(int id) {
        return mapper.toAuthorsDto(repository.findById(id).orElse(null));
    }

    public void deleteAuthorsById(int id) {
        repository.deleteById(id);
    }

    public List<AuthorsDto> findAuthorsByName(String name) {
        return repository.findAllByName(name).stream()
                .map(mapper::toAuthorsDto)
                .collect(Collectors.toList());
    }

    public List<AuthorsDto> findAllAuthorsNamedQuery() {
        return repository.findAllTest()
                .stream()
                .map(mapper::toAuthorsDto)
                .collect(Collectors.toList());
    }
}
