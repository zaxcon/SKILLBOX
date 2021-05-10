package com.example.firstSpringBootApp.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book2genre" )
public class BookToGenre {

    private BookGenreId bookGenreId =new BookGenreId();

    @EmbeddedId
    public BookGenreId getBookGenreId() {
        return bookGenreId;
    }

    public void setBookGenreId(BookGenreId bookGenreId) {
        this.bookGenreId = bookGenreId;
    }
}
