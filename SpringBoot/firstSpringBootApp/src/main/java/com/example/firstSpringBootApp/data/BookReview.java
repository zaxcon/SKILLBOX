package com.example.firstSpringBootApp.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date time;
    private String text;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
}
