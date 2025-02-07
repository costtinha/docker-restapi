package com.example.new_docker.books_authors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_AuthorsRepository extends JpaRepository<Books_Authors,Books_Authors_Key> {
}
