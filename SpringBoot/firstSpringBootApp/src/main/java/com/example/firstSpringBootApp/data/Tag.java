package com.example.firstSpringBootApp.data;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@ApiModel(description = "entity representing a tags")
public class Tag {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String tagName;

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
