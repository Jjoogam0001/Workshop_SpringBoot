package Data;

import Entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {

    BookLoan create(BookLoan bookLoan);
    BookLoan findById(Integer bookloadId);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    boolean delete(Integer bookloanId);
}
