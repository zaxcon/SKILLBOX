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
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksdata() {
        List<Book> books = jdbcTemplate.query("SELECT BOOKS.id,books.title,books.priceold, books.price, authors.id as author_id, authors.name, authors.surname  FROM BOOKS join authors on authors.id=books.author_id", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName(rs.getString("name"));
            author.setSurname(rs.getString("surname"));
            book.setId(rs.getInt("id"));
            book.setAuthor(author);
            book.setTitle(rs.getString("title"));
            book.setPrice(rs.getString("price"));
            book.setPriceOld(rs.getString("priceOld"));
            return book;
        });

        return new ArrayList<>(books);

    }


}