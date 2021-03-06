package com.example.firstSpringBootApp.data.services;

import com.example.firstSpringBootApp.data.Author;
import com.example.firstSpringBootApp.data.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<Character, List<Author>> getAuthors() {
        return authorRepository.findAll().stream().collect(Collectors.groupingBy(c->c.getName().charAt(0)));
    }
    public Author getAuthorById(Integer id)
    {
        return authorRepository.findById(id).get();
    }
}
