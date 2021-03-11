package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.AuthorDao;
import com.workshop.lexicon.Entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AuthorDaoImpl implements AuthorDao{


    private final EntityManager em;


    @Autowired
    public AuthorDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Author create(Author author) {
        em.persist(author);
        return author;
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(Integer authorId) {
        return em.find(Author.class,authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return em
                    .createQuery("SELECT authors FROM Author authors", Author.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Author update(Author author) {
        return em.merge(author);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer authorId) {
        Author toRemove = findById(authorId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("Author could not be found");
        }
        toRemove = findById(authorId);
        return toRemove == null;
    }
}
