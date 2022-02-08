package com.example.BookStore.Model;



import javax.persistence.*;
import java.util.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long ISBN;
    private String title;
    private Integer  numberOfCopies;

    @OneToOne( cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne( cascade = CascadeType.ALL)
    private Publisher publisher;

    @ManyToMany(mappedBy = "bookList",cascade = CascadeType.ALL)
    private List<Author> authorList = new ArrayList<Author>();



    public Book() {
    }


    public Book(String title, Integer numberOfCopies, Category category, Publisher publisher, List<Author> authorList) {
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.category = category;
        this.publisher = publisher;
        this.authorList = authorList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        publisher.addBook(this);
        this.publisher = publisher;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
        for(Author a : authorList) {
            a.addBookList(this);
        }
    }

    public void addAuthorList(Author author){
        this.authorList.add(author);

    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", category=" + category +
                ", publisher=" + publisher +
                ", authorList=" + authorList +
                '}';
    }
}
