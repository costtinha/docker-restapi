package com.example.new_docker.authors;

import org.springframework.stereotype.Service;

@Service
public class AuthorsMapper {
    public AuthorsDto toAuthorsDto(Authors authors){
        return new AuthorsDto(authors.getName(), authors.getBio());
    }
    public Authors toAuthors(AuthorsDto dto){
        return new Authors(dto.name(), dto.bio());
    }
}
