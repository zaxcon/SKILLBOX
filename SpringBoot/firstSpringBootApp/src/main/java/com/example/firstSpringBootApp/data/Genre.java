package com.example.firstSpringBootApp.data;


import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre implements Comparable<Genre> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parentId;
    private String slug;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "book2genre",
            joinColumns = { @JoinColumn(name = "genre_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Book> booksGenreSet = new HashSet<Book>();

    public Set<Book> getBooksGenreSet() {
        return booksGenreSet;
    }

    public void setBooksGenreSet(Set<Book> booksGenreSet) {
        this.booksGenreSet = booksGenreSet;
    }

    @OneToMany(mappedBy = "parentId", fetch = FetchType.EAGER)
    private Set<Genre> genreParentSet;

    public Set<Genre> getGenreParentSet() {
        return genreParentSet;
    }

    public Integer getGenreChildSetElementsCount()
    {
      Integer it=    getGenreParentSet().stream().map(genre -> { return genre.getGenreParentSet().size();}).reduce(0,Integer::sum);
        System.out.println("it"+it);
      return it;
    }

    public void setGenreParentSet(Set<Genre> genreParentSet) {
        this.genreParentSet = genreParentSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Genre o) {
        return Integer.compare(o.id,id);
    }


}
