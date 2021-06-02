package com.example.firstSpringBootApp.data;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@ApiModel(description = "entity representing a tags")
public class Tag {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String tagName;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "book2tag",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Book> booksTagSet = new HashSet<Book>();

    public Integer getId() {
        return id;
    }

    public Integer getBooksSize(){
        return booksTagSet.size();
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Book> getBooksTagSet() {
        return booksTagSet;
    }

    public void setBooksTagSet(Set<Book> booksTagSet) {
        this.booksTagSet = booksTagSet;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
