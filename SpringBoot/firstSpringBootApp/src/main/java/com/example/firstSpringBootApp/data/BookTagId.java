package com.example.firstSpringBootApp.data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookTagId  implements Serializable {
    private Book book;
    private Tag tag;

    @ManyToOne
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @ManyToOne
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTagId bookTagId = (BookTagId) o;
        return Objects.equals(book, bookTagId.book) && Objects.equals(tag, bookTagId.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, tag);
    }
}
