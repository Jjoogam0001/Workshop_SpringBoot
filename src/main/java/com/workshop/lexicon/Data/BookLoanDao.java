package com.workshop.lexicon.Data;

import com.workshop.lexicon.Entity.Author;
import com.workshop.lexicon.Entity.BookLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookLoanDao  {

    BookLoan create(BookLoan bookLoan);
    BookLoan findById(Integer bookLoadId);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    boolean delete(Integer bookId);
}
