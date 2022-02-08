package com.example.BookStore.Controller;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{authorId}")
    public List<Author> getAuthorById(@PathVariable Long authorId){
        return bookService.getAuthorById(authorId);
    }

    @GetMapping("/bookId/{bookISBN}")
    public List<Author> getAuthorsOfaBook(@PathVariable Long bookISBN){
        return bookService.getAllAuthorsInThisBook(bookISBN);
    }

    @GetMapping("/{authorId}/bio")
    public String getAuthorBio(@PathVariable Long authorId){
        return bookService.getAuthorBio(authorId);
    }
}
