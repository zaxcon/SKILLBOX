package com.example.firstSpringBootApp.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book2tag" )
public class BookToTag {

    private BookTagId key=new BookTagId();

    @EmbeddedId
    public BookTagId getKey() {
        return key;
    }

    public void setKey(BookTagId key) {
        this.key = key;
    }

}
