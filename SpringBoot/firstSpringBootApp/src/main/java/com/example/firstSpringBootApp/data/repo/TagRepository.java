package com.example.firstSpringBootApp.data.repo;

import com.example.firstSpringBootApp.data.Book;
import com.example.firstSpringBootApp.data.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface TagRepository extends JpaRepository<Tag,Integer> {


}
