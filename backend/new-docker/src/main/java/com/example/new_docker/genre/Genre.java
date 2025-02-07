package com.example.new_docker.genre;
import com.example.new_docker.books.Books;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private int genre_id;
    @Column(
            length = 50
    )
    private String name;
    private String description;
    @OneToMany(mappedBy ="genre_id")
    @JsonManagedReference
    private List<Books> booksList;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre() {
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }
}
