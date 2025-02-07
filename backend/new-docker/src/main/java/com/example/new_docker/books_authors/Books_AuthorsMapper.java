package com.example.new_docker.books_authors;

import com.example.new_docker.authors.Authors;
import com.example.new_docker.books.Books;
import org.springframework.stereotype.Service;

@Service
public class Books_AuthorsMapper {
    public  Books_Authors toBook_Authors(Books_AuthorsDto dto){
        Books_Authors_Key key = new Books_Authors_Key();
        key.setAuthors_id(dto.authors_id());
        key.setBooks_id(dto.books_id());
        Books book = new Books();
        book.setBook_id(dto.books_id());
        Authors authors = new Authors();
        authors.setId(dto.authors_id());
        return new Books_Authors(key,book,authors);
    }

    public Books_AuthorsDto toBook_AuthorsDto(Books_Authors books_authors){
        return new Books_AuthorsDto(books_authors.getBooks_id().getBook_id(),books_authors.getAuthors_id().getId());
    }
}
