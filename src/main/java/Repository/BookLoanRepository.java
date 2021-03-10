package Repository;

import Data.BookLoanDao;
import Entity.BookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class BookLoanRepository implements BookLoanDao {

    private final EntityManager em;
    @Autowired
    public BookLoanRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public BookLoan create(BookLoan bookLoan) {
        em.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(Integer bookloadId) {
        return em.find(BookLoan.class,bookloadId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return em
                .createQuery("SELECT booksLoan FROM BookLoan booksLoan", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public BookLoan update(BookLoan bookLoan) {
        return em.merge(bookLoan);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer bookloanId) {
        BookLoan toRemove = findById(bookloanId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("BookLoan could not be found");
        }
        toRemove = findById(bookloanId);
        return toRemove == null;
    }
}
