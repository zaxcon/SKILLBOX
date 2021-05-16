package com.example.firstSpringBootApp.data.services;

import com.example.firstSpringBootApp.data.Book;
import com.example.firstSpringBootApp.data.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BookService {


    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getRecommendedBooksData() {
        return bookRepository.findAll();
    }

    public List<Book> getRecentBooksData()
    {
        //mock
        return getRecommendedBooksData();
    }

    public List<Book> getPopularBooksData()
    {
        //mock
        return getRecommendedBooksData();
    }
    //NEW BOOK SEVICE METHODS

//    public List<Book> getBooksByAuthor(String authorName){
//        return bookRepository.findBooksByAuthorFirstNameContaining(authorName);
//    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min,max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Book book=bookRepository.findBooksById(1);
        book.printTags();
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }
    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }
    public Page<Book> getPageOfRecentBooks(String from, String to,Integer offset, Integer limit)  {
        Pageable nextPage = PageRequest.of(offset,limit, Sort.by("pubDate").descending());
        if ((from==null)||(to==null))
        {return bookRepository.findAll(nextPage);}else
        {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                return bookRepository.findBooksByPubDateBetween(new Date(format.parse(from).getTime()),new Date(format.parse(to).getTime()), nextPage);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return bookRepository.findAll(nextPage);
    }
    public Page<Book> getPageOfRecentBooksWithDates(Date from, Date to, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit, Sort.by("pubDate").descending());
        return bookRepository.findBooksByPubDateBetween(from,to, nextPage);
    }
    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBookByTitleContaining(searchWord,nextPage);
    }
}