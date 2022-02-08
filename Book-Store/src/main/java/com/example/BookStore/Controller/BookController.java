package com.example.BookStore.Controller;


import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Publisher;
import com.example.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //Works
    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    //Works
    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

//Works
    @PostMapping("/addbook/categoryId/{categoryId}")
    public void addBookInExistingCategory(@RequestBody Book book , @PathVariable Long categoryId){
        bookService.addBookByCategory(book,categoryId);
    }

    //works
    @PostMapping ("/addBook/authorId/{authorId}")
    public void addBookInExistingAuthorId(@PathVariable Long authorId, @RequestBody Book book ){
        bookService.addBookByAuthor(book , authorId);
    }
//works
    @PostMapping("addBook/authorId/{authorId}/categoryId/{categoryId}")
    public void addBookInExistingAuthorAndCategory(@RequestBody Book book , @PathVariable Long authorId ,@PathVariable Long categoryId){
        bookService.addBookByAuthorAndCategory(book,categoryId,authorId);
    }

    //Works

    @GetMapping("/isbn/{ISBN}")
    public Book getBookByISBN(@PathVariable Long ISBN){
        return bookService.getBookByISBN(ISBN);
    }

    //Works

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

    //Works

    @GetMapping("/category/{categoryId}")
    public List<Book> getBooks(@PathVariable Long categoryId){
        return bookService.getBookByCategory(categoryId);
    }

    //Works

    @GetMapping("/numberofcopies/{numberOfCopies}")
    public List<Book> getBookWithNumberOfCopies(@PathVariable Integer numberOfCopies){
        return bookService.getBookWithNumberOfCopiesEquals(numberOfCopies);
    }

    //Works

    @GetMapping("/authorid/{authorId}")
    public List<Book> getBookByAuthorId(@PathVariable Long authorId){
        return bookService.getBookByAuthorListId(authorId);
    }

    //Works

    @GetMapping("/authorname/{authorName}")
    public List<Book> getBookByAuthorName(@PathVariable String authorName){
        return bookService.getBookByAuthorListName(authorName);
    }

    //doesn't work
    @PutMapping("/updateBook/{bookId}")
    public void updateBook(@RequestBody Book book,@PathVariable Long bookId){
        book.setISBN(bookId);
        bookService.updateBook(book);
    }

    //Works like a charm
    @DeleteMapping("delete/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }



//Works
    @GetMapping("/publisher/{bookId}")
    public Publisher getPublisherOfBook(@PathVariable Long bookId){
        return  bookService.getPublisherOfABook(bookId);
    }


//get back at it
    @PostMapping("/addAuthor/bookId/{bookId}/authorId/{authorId}")
    public void addAuthorToABook( @PathVariable  Long bookId , @PathVariable Long authorId ){
        bookService.addAuthorToExistingBook(bookId,authorId);
    }



}
