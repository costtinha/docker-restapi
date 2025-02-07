package com.example.new_docker.books;


import com.example.new_docker.genre.Genre;
import org.springframework.stereotype.Service;

@Service
public class BooksMapper {
    public Books toBooks(BooksDto dto){
        Genre genre = new Genre();
        genre.setGenre_id(dto.genre_id());
        return new Books(dto.title(), dto.book_description(), genre);
    }
    public BooksDto toBooksDto(Books books){
        return new BooksDto(books.getTitle(), books.getBook_description(), books.getGenre_id().getGenre_id());
    }
}
