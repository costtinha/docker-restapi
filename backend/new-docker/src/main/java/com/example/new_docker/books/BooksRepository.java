package com.example.new_docker.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books,Integer> {
    List<Books> findBooksByTitle(@Param("title") String title);
}
