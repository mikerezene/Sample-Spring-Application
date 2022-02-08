package com.example.BookStore.Repository;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    public List<Book> findByTitle(String title);

    public List<Book> findBookByNumberOfCopiesEquals(Integer numberOfBooks);

    public Optional<Book> findByISBN(Long ISBN);

//    public List<Book> findBooksByPublishedDate(Date publishedDate);

    @Query("select b from Book as b JOIN b.category as c where c.id = :catagoryId")
    public List<Book> findByCategoryId(Long catagoryId);

    @Query("select b from Book as b JOIN b.authorList as a where a.id = :authorId")
    public List<Book> findBookByAuthorListId(Long authorId);

    @Query("select b from Book as b JOIN b.authorList as a where a.authorName = :authorName")
    public List<Book> findBookByAuthorListName(String authorName);

    @Query("select a from Book as b JOIN b.authorList as a where b.ISBN = :bookId")
    public List<Author> findAuthorListByBookId(Long bookId);

}
