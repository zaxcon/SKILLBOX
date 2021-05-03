package com.example.firstSpringBootApp.controllers;

import com.example.firstSpringBootApp.data.AuthorsService;
import com.example.firstSpringBootApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bookshop")
public class MainPageController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/main")
    public String mainPage(Model model)
    {
        model.addAttribute("booksData", bookService.getBooksdata());

        return "index";
    }
    @GetMapping("/genres")
    public String genresPage(Model model)
    {
        return "genres/index";
    }
    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("authors",authorsService.getAuthors());
        return "authors/index";
    }
}
