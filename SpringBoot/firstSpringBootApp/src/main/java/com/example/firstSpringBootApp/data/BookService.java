package com.example.firstSpringBootApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {


    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getRecommendedBooksData() {
        return bookRepository.findAll();
    }

    public List<Book> getRecentBooksData()
    {
        //mock
        return getRecommendedBooksData();
    }


    public List<Book> getPopularBooksData()
    {
        //mock
        return getRecommendedBooksData();
    }
}