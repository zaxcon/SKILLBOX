package org.example.app.services;

import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }
    public List<Book> searchBooks(Book book)
    {
        Predicate<Book> predicateBook= null;

        if (!book.getAuthor().isEmpty()) {
            predicateBook=getPredicate(predicateBook,book1 -> book1.getAuthor().contains(book.getAuthor()));
        }
        if (!book.getTitle().isEmpty()) {
            predicateBook=getPredicate(predicateBook,book1 -> book1.getTitle().contains(book.getTitle()));
        }
        if (book.getSize()!=null) {
            predicateBook=getPredicate(predicateBook,book1 -> book1.getSize()<=book.getSize());
        }
        if (book.getId()!=null) {
            predicateBook=getPredicate(predicateBook,book1 -> book1.getId().equals(book.getId()));
        }

        List<Book> books =getAllBooks().stream().filter(predicateBook).collect(Collectors.toList());
        return books;
    }

    private Predicate<Book> getPredicate(Predicate<Book> predicateBook,Predicate<Book> predicateProperty)
    {
        if (predicateBook==null)
        {
            predicateBook=predicateProperty;
        }else {
        predicateBook = predicateBook.and(predicateProperty);
    }
        return predicateBook;
    }

    public void removeFiltered(Book book) {
       List<Book> books =  searchBooks(book);
       for (Book bookInList:books)
       {
           removeBookById(bookInList.getId());
       }
    }
}
