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
        model.addAttribute("recommendedBooksData", bookService.getRecommendedBooksData());
        model.addAttribute("recentBooksData", bookService.getRecentBooksData());
        model.addAttribute("popularBooksData", bookService.getPopularBooksData());
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
    @GetMapping("/signin")
    public String signinPage(Model model)
    {
        return "signin";
    }

    @GetMapping("/signup")
    public String signupPage(Model model)
    {
        return "signup";
    }
    @GetMapping("/contacts")
    public String contactsPage(Model model)
    {
        return "contacts";
    }
    @GetMapping("/faq")
    public String faqPage(Model model)
    {
        return "faq";
    }
    @GetMapping("/about")
    public String aboutPage(Model model)
    {
        return "about";
    }
    @GetMapping("/documents")
    public String documentsPage(Model model)
    {
        return "documents";
    }
    @GetMapping("/postponed")
    public String postponedPage(Model model)
    {
        return "postponed";
    }
    @GetMapping("/cart")
    public String cartPage(Model model)
    {
        return "cart";
    }
    @GetMapping("/recent")
    public String recentPage(Model model)
    {
        return "books/recent";
    }
    @GetMapping("/popular")
    public String popularPage(Model model)
    {
        return "books/popular";
    }
}
