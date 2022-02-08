package com.example.BookStore.Service;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Category;
import com.example.BookStore.Model.Publisher;
import com.example.BookStore.Repository.AuthorRepository;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Repository.CategoryRepository;
import com.example.BookStore.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BookService(AuthorRepository authorRepository , BookRepository bookRepository,
    CategoryRepository categoryRepository , PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookByISBN(Long ISBN){
        return bookRepository.findByISBN(ISBN).get();
    }

    public List<Book> getBookByCategory(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }

    public List<Book> getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBookWithNumberOfCopiesEquals(Integer value){
        return bookRepository.findBookByNumberOfCopiesEquals(value);
    }

    public List<Book> getBookByAuthorListId(Long authorId){
        return bookRepository.findBookByAuthorListId(authorId);
    }

    public List<Book> getBookByAuthorListName(String authorName){
        return bookRepository.findBookByAuthorListName(authorName);
    }


    public List<Author> getAuthorById(Long authorId){
        return authorRepository.findAll();
    }

    public List<Author> getAllAuthorsInThisBook(Long bookId){
        return bookRepository.findAuthorListByBookId(bookId);
    }

    public String getAuthorBio(Long authorId){
        return authorRepository.findById(authorId).get().getBio();
    }



    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id){
        return publisherRepository.findById(id).get();
    }


    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void addBookByCategory(Book book , Long categoryId){
        Category category = categoryRepository.findById(categoryId).get();
        book.setCategory(category);
        bookRepository.save(book);
    }

    public void addBookByAuthor(Book book , Long authorId){
        System.out.println("bumba"+authorId);
        Author author = authorRepository.findById(authorId).get();
        book.setAuthorList(List.of(author));

        bookRepository.save(book);
    }

    public void addBookByAuthorAndCategory(Book book , Long categoryId,Long authorId){
        Author author = authorRepository.findById(authorId).get();
        book.setAuthorList(List.of(author));
        Category category = categoryRepository.findById(categoryId).get();
        book.setCategory(category);

        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
         Book book =  bookRepository.findByISBN(bookId).get();
        bookRepository.delete(book);
    }

    public Publisher getPublisherOfABook(Long bookId){
        System.out.println(bookId + " and ");
        Book book = bookRepository.findByISBN(bookId).get();
        return book.getPublisher();

    }

    public void addAuthorToExistingBook(Long bookId , Long authorId){
        System.out.println("This is the booId"+ bookId + " and " + authorId);
        Book book = bookRepository.findByISBN(bookId).get();
        Author author = authorRepository.findById(authorId).get();
//        author.addBookList(book);
        book.addAuthorList(author);

        System.out.println("This is the booId"+ book + " and " + author);



        bookRepository.save(book);

    }


}
