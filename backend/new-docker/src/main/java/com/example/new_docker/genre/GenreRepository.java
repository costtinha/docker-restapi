package com.example.new_docker.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    List<Genre> findGenreByName(@Param("name") String name);
}
