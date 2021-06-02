package com.example.firstSpringBootApp.controllers;

import com.example.firstSpringBootApp.data.*;
import com.example.firstSpringBootApp.data.services.AuthorsService;
import com.example.firstSpringBootApp.data.services.BookService;
import com.example.firstSpringBootApp.data.services.GenreService;
import com.example.firstSpringBootApp.data.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/bookshop")
public class MainPageController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private TagService tagService;

    @Autowired
    private GenreService genreService;

    @ModelAttribute("tagsData")
    public Map<Tag,String> getTags()
    {
        return tagService.getTagsMap();
    }

    @ModelAttribute("recommendedBooksData")
    public List<Book> recommendedBooks() {
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }
    @ModelAttribute("popularBooksData")
    public List<Book> popularBooksData() {
        return bookService.getPageOfPopularBooks(0, 6).getContent();
    }

    @ModelAttribute("recentBooksData")
    public List<Book> recentBooksData() {
        return bookService.getPageOfRecentBooks(null,null,0, 6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        return bookService.getPageOfRecentBooks(null,null,0, 20).getContent();
    }
    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return bookService.getPageOfRecentBooks(null,null,0, 20).getContent();
    }
    @GetMapping("/main")
    public String mainPage(Model model)
    {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
    }
    @GetMapping("/books/popular")
    @ResponseBody
    public BooksPageDto getPopularBooksPage(@RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfPopularBooks(offset, limit).getContent());
    }
    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDto getRecentBooksPage(@RequestParam(value = "from",required = false) String from,@RequestParam(value = "to",required = false) String to,@RequestParam("offset") Integer offset,
                                            @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfRecentBooks(from, to, offset, limit).getContent());
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                   Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults",
                bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 6).getContent());
        return "/search/index";
    }
    @GetMapping("/books/tag/{id}")
    public String getTagResults(@PathVariable(value = "id", required = true) Integer id,
                                   Model model) {
        model.addAttribute("tag", tagService.getTagById(id));
        model.addAttribute("tagBooks",
                bookService.getBooksByTag(tagService.getTagById(id), 0, 6).getContent());
        return "tags/index";
    }

    @GetMapping("/books/genre/{id}")
    public String getGenreResults(@PathVariable(value = "id", required = true) Integer id,
                                Model model) {
        model.addAttribute("Breadcrumbs",genreService.getBreadCrumbs(genreService.getBookById(id)));
        model.addAttribute("genre", genreService.getBookById(id));
        model.addAttribute("genreBooks",
                bookService.getBooksByGenre(genreService.getBookById(id), 0, 6).getContent());
        return "genres/slug";
    }


    @GetMapping( "/books/tags/{id}")
    @ResponseBody
    public BooksPageDto getTagsBooksPage(@PathVariable(value = "id", required = true) Integer id,
                                        @RequestParam("offset") Integer offset,
                                            @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getBooksByTag(tagService.getTagById(id),offset, limit).getContent());
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }
    @GetMapping("/genres")
    public String genresPage(Model model)
    {
        model.addAttribute("genres",genreService.getGenreMap());
        return "genres/index";
    }
    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("authors",authorsService.getAuthors());
        return "authors/index";
    }
    @GetMapping("/books/author/{id}")
    public String getAuthorResults(@PathVariable(value = "id", required = true) Integer id,
                                  Model model) {
        model.addAttribute("author", authorsService.getAuthorById(id));
        model.addAttribute("booksAuthor", authorsService.getAuthorById(id).getBooksAuthor());
        return "authors/slug";
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
