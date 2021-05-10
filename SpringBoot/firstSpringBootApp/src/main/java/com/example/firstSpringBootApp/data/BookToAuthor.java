package com.example.firstSpringBootApp.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "book2author")
public class BookToAuthor implements Comparable<BookToAuthor>{

    private BookAuthorId key=new BookAuthorId();
    private  Integer sortIndex;

    @EmbeddedId
    public BookAuthorId getKey() {
        return key;
    }

    public void setKey(BookAuthorId key) {
        this.key = key;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookToAuthor that = (BookToAuthor) o;
        return Objects.equals(key, that.key) && Objects.equals(sortIndex, that.sortIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, sortIndex);
    }


    @Override
    public int compareTo(BookToAuthor o) {
        return Integer.compare(sortIndex,o.sortIndex);
    }
}
