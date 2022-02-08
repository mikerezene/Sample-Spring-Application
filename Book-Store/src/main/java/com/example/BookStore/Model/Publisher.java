package com.example.BookStore.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<Book>();

    public Publisher() {
    }


    public Publisher(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void addBook(Book book){
        books.add(book);
    }

}
