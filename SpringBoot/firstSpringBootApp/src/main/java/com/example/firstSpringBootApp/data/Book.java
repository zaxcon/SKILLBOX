package com.example.firstSpringBootApp.data;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
@ApiModel(description = "entity representing a book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated by db automaticaly")
    private Integer id;
    @ApiModelProperty("date of book publication")
    private Date pubDate;
    private boolean isBestseller;
    @ApiModelProperty("mnemonical identity sequence of characters")
    private String slug;
    @ApiModelProperty("image url")
    private String image;
    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("book description text")
    private String description;
    @ApiModelProperty("book price without discount")
    private Integer price;
    @ApiModelProperty("discount value for book")
    private Integer discount;

   @OneToMany( mappedBy = "key.book")
    private Set<BookToAuthor> bookToAuthorSet = new HashSet<BookToAuthor>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "book2tag",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> booksTagSet = new HashSet<Tag>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "book2genre",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    private Set<Genre> booksGenreSet = new HashSet<Genre>();

    @ApiModelProperty("book title")
    private  String title;

    public Set<BookToAuthor> getBookToAuthorSet() {
        return bookToAuthorSet;
    }

    public void setBookToAuthorSet(Set<BookToAuthor> bookToAuthorSet) {
        this.bookToAuthorSet = bookToAuthorSet;
    }

    public String getAuthors()
    {
        return  bookToAuthorSet.stream().sorted()
                .map(bookToAuthor -> {
                    return bookToAuthor.getKey().getAuthor().toString();
                })
                .collect(Collectors.joining(", "));
    }
    public void printTags()
    {
        System.out.println(this.toString());
        for (Tag tag :booksTagSet)
        {
            System.out.println(tag);
        }
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pubDate=" + pubDate +
                ", is_bestseller=" + isBestseller +
                ", slug='" + slug + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", title='" + title + '\'' +
                '}';
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public boolean isIs_bestseller() {
        return isBestseller;
    }

    public void setIs_bestseller(boolean isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getPrice() {
        return price;
    }


}
