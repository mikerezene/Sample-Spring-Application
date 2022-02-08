package com.example.BookStore.Controller;


import com.example.BookStore.Model.Publisher;
import com.example.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Publisher> getAllPublishers(){
        return bookService.getAllPublisher();
    }

    @GetMapping("/publisherId/{publisherId}")
    public Publisher getPublisherById(@PathVariable Long publisherId){
        return bookService.getPublisherById(publisherId);
    }
}
