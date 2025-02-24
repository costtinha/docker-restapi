package com.example.new_docker.authors;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors,Integer> {
    List<Authors> findAllByName(@Param("name") String name);
    List<Authors> findAllTest();
}
