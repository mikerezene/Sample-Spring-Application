package com.example.BookStore.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String authorName;
    private String bio;

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Book> bookList = new ArrayList<Book>();

    public Author(String authorName, String bio, List<Book> bookList) {
        this.authorName = authorName;
        this.bio = bio;
        this.bookList = bookList;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBookList(Book bookList) {
        this.bookList.add(bookList);
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bio='" + bio + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
