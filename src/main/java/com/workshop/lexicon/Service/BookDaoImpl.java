package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.BookDao;
import com.workshop.lexicon.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao {


    private final EntityManager em;
     @Autowired
    public BookDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Book create(Book book) {
         em.persist(book);
        return book;
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Integer bookId) {
        return em.find(Book.class,bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return em
                .createQuery("SELECT books FROM Book books", Book.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Book update(Book book) {
        return em.merge(book);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer bookId) {
        Book toRemove = findById(bookId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("Book could not be found");
        }
        toRemove = findById(bookId);
        return toRemove == null;
    }
}
