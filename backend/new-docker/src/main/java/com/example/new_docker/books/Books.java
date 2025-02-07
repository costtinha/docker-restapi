package com.example.new_docker.books;


import com.example.new_docker.books_authors.Books_Authors;
import com.example.new_docker.genre.Genre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Books {
    @Id
    @GeneratedValue
    private int books_id;
    private String title;
    private  String book_description;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "genre_i"
    )
    private Genre genre_id;

    @OneToMany(mappedBy = "books_id")
    @JsonManagedReference
    private List<Books_Authors> books_authors = new ArrayList<>();

    public Books(String title, String book_description, Genre genre_id) {
        this.title = title;
        this.book_description = book_description;
        this.genre_id = genre_id;
    }

    public Books() {
    }

    public int getBook_id() {
        return books_id;
    }

    public void setBook_id(int book_id) {
        this.books_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public Genre getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Genre genre_id) {
        this.genre_id = genre_id;
    }

    public List<Books_Authors> getBooks_authors() {
        return books_authors;
    }

    public void setBooks_authors(List<Books_Authors> books_authors) {
        this.books_authors = books_authors;
    }
}
