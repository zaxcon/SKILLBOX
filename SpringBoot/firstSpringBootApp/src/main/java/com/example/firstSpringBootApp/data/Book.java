package com.example.firstSpringBootApp.data;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date pubDate;
    private boolean is_bestseller;
    private String slug;
    private String image;
    private String description;

    private Integer price;
    private Integer discount;

    @OneToMany( mappedBy = "book")
    private List<BookReview> bookReviewList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "key.book")
    private Set<BookToAuthor> bookToAuthorSet = new HashSet<BookToAuthor>();
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
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pubDate=" + pubDate +
                ", is_bestseller=" + is_bestseller +
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
        return is_bestseller;
    }

    public void setIs_bestseller(boolean is_bestseller) {
        this.is_bestseller = is_bestseller;
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
