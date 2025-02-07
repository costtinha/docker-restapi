package com.example.new_docker.authors;


import com.example.new_docker.books_authors.Books_Authors;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Authors {

    @Id
    @GeneratedValue
    private int Id;

    @Column(
            length= 80
    )
    private String name;

    private String bio;

    @OneToMany(mappedBy = "authors_id")
    @JsonManagedReference
    private List<Books_Authors> books_authors = new ArrayList<>();

    public Authors(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Authors() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
