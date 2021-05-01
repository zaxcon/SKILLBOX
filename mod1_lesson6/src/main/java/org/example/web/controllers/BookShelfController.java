package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        }
        bookService.saveBook(book);
        logger.info("current repository size: " + bookService.getAllBooks().size());
        return "redirect:/books/shelf";
    }

    @PostMapping("/search")
    public String searchBooks(Book book,Model model) {
        if (book.isEmpty())
        {
            logger.error("Search query is empty: ");
            return "redirect:/books/shelf";
        }else {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.searchBooks(book));
            return "book_shelf";
        }


    }


    @PostMapping("/remove")
    public String removeBook(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove) {
         bookService.removeBookById(bookIdToRemove);
          return "redirect:/books/shelf";

    }
    @PostMapping("/removeselected")
    public String removeSelectedBooks(@RequestParam(value = "checked" , required = false) int[] booksId) {
        if (booksId!=null)
        {
            for (int i = 0; i < booksId.length; i++) {
                logger.error("Try delete book with ID "+booksId[i]);
                bookService.removeBookById(booksId[i]);
            }
        }
        return "redirect:/books/shelf";

    }
    @PostMapping("/removefiltered")
    public String removeFiltereddBooks(Book book) {

        if (book.isEmpty())
        {
            logger.error("Search query is empty: ");

        }else {
            logger.error("Try delete book with filter");
            bookService.removeFiltered(book);

        }
        return "redirect:/books/shelf";
    }
}
