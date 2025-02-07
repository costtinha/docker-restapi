package com.example.new_docker.books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BooksMapper mapper;
    private final BooksRepository repository;

    public BooksService(BooksMapper mapper, BooksRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<BooksDto> findAllBooks() {
        return repository.findAll()
                .stream()
                .map(mapper::toBooksDto)
                .collect(Collectors.toList());
    }

    public BooksDto saveBook(BooksDto dto) {
        return mapper.toBooksDto(repository.save(mapper.toBooks(dto)));
    }

    public BooksDto findBookById(int id) {
        return mapper.toBooksDto(repository.findById(id).orElse(null));
    }

    public void deleteBookById(int id) {
        repository.deleteById(id);
    }
}
