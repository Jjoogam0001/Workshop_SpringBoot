package com.workshop.lexicon.Data;

import com.workshop.lexicon.Entity.Author;
import com.workshop.lexicon.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookDao {

    Book create(Book bookId);
    Book findById(Integer bookId);
    Collection<Book> findAll();
    Book update(Book book);
    boolean delete(Integer bookId);


}
