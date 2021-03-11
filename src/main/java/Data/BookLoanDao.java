package Data;

import Entity.Book;
import Entity.BookLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookLoanDao extends CrudRepository<BookLoan,Integer> {

    Optional<BookLoan> findByBookLoanById(Integer id);
}
