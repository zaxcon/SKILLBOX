package com.example.firstSpringBootApp.data.repo;

import com.example.firstSpringBootApp.data.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    List<Genre> findAllByParentId(Integer id);
}
