package com.example.new_docker.books_authors;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Books_AuthorsService {
    private final Books_AuthorsMapper mapper;
    private final  Books_AuthorsRepository repository;

    public Books_AuthorsService(Books_AuthorsMapper mapper, Books_AuthorsRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    public List<Books_AuthorsDto> findAllBooks_Authors() {
        return repository.findAll()
                .stream()
                .map(mapper::toBook_AuthorsDto)
                .collect(Collectors.toList());
    }

    public Books_AuthorsDto saveBooks_Authors(Books_AuthorsDto dto) {
        Books_Authors books_authors = mapper.toBook_Authors(dto);
        repository.save(books_authors);
        return dto;
    }

    public Books_AuthorsDto findBooks_AuthorsById(int booksId, int authorsId) {
        Books_Authors_Key key = new Books_Authors_Key(booksId,authorsId);
        return mapper.toBook_AuthorsDto(repository.findById(key).orElse(null));
    }

    public void deleteBooks_AuthorsById(int booksId, int authorsId) {
        Books_Authors_Key key = new Books_Authors_Key(booksId,authorsId);
        repository.deleteById(key);
    }
}
