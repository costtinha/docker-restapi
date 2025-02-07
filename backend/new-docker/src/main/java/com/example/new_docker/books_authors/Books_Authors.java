package com.example.new_docker.books_authors;

import com.example.new_docker.authors.Authors;
import com.example.new_docker.books.Books;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Books_Authors {
    @EmbeddedId
    private Books_Authors_Key compositeId;

    @ManyToOne
    @MapsId("books_id")
    @JsonBackReference
    @JoinColumn(
            name="books_id"
    )
    private Books books_id;

    @ManyToOne
    @MapsId("authors_id")
    @JsonBackReference
    @JoinColumn(
            name = "authors_id"
    )
    private Authors authors_id;

    public Books_Authors(Books_Authors_Key compositeId, Books books_id, Authors authors_id) {
        this.compositeId = compositeId;
        this.books_id = books_id;
        this.authors_id = authors_id;
    }

    public Books_Authors() {
    }

    public Books_Authors_Key getCompositeId() {
        return compositeId;
    }

    public void setCompositeId(Books_Authors_Key compositeId) {
        this.compositeId = compositeId;
    }

    public Books getBooks_id() {
        return books_id;
    }

    public void setBooks_id(Books books_id) {
        this.books_id = books_id;
    }

    public Authors getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(Authors authors_id) {
        this.authors_id = authors_id;
    }
}
