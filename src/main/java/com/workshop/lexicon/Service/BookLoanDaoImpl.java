package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.BookLoanDao;
import com.workshop.lexicon.Entity.BookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository

public class BookLoanDaoImpl implements BookLoanDao {

    private final EntityManager em;

    @Autowired
    public BookLoanDaoImpl(EntityManager em) {
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
    public BookLoan findById(Integer bookLoadId) {
        return em.find(BookLoan.class,bookLoadId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return  em
                .createQuery("SELECT booksloan FROM BookLoan booksloan", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public BookLoan update(BookLoan bookLoan) {
        return em.merge(bookLoan);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer bookId) {
        BookLoan toRemove = findById(bookId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("BookLoan could not be found");
        }
        toRemove = findById(bookId);
        return toRemove == null;
    }
}
