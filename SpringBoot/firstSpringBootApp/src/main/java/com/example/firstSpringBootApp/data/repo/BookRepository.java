package com.example.firstSpringBootApp.data.repo;

import com.example.firstSpringBootApp.data.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

//    List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);


    List<Book> findBooksByTitleContaining(String bookTitle);

    Page<Book> findBooksByPubDateBetween(Date from, Date to, Pageable nextPage);

    List<Book> findBooksByPriceBetween(Integer min, Integer max);
    Book findBooksById(Integer id);
    List<Book> findBooksByPriceIs(Integer price);

    @Query("from Book where isBestseller=true")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);
}
