package com.example.new_docker.authors;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors,Integer> {
}
