package com.example.firstSpringBootApp.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book_review_like")
public class BookReviewLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private BookReviewLike bookReviewLike;
    @ManyToOne
    private User user;
    private Date time;
    private Integer value;
}
