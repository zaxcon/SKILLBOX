package com.example.firstSpringBootApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorsService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<Character, List<Author>> getAuthors() {
        Character[] characters = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Map<Character, List<Author>> map = new HashMap<>();
        for (Character c : characters) {
            List<Author> authors = jdbcTemplate.query("select * from authors where surname like '" + c + "%'", (ResultSet rs, int rowNum) -> {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setSurname(rs.getString("surname"));
                return author;
            });
            map.put(c, authors);
        }
        return map;
    }
}
