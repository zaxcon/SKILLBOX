package org.example.web.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private Integer id;
    @NotEmpty(message = "author should not be empty")
    private String author;
    @NotEmpty(message = "title should not be empty")
    private String title;
    @Digits(integer = 5,fraction = 0, message = "should be digits only")
    @Min(value = 0, message = "size should be greater than 0")
    private Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isEmpty()
    {
      return author.isEmpty()&title.isEmpty()&(size==null)&(id==null);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
