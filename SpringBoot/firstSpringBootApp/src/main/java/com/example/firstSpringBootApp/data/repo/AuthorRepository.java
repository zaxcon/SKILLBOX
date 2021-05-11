package com.example.firstSpringBootApp.data.repo;

import com.example.firstSpringBootApp.data.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author,Integer> {
}
