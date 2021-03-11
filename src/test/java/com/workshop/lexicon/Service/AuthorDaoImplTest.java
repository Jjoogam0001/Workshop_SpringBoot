package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.AuthorDao;
import com.workshop.lexicon.Data.BookDao;
import com.workshop.lexicon.Entity.Author;
import com.workshop.lexicon.Entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext

class AuthorDaoImplTest {


    @Autowired
    private AuthorDao testObject;
    @Autowired private TestEntityManager em;

    private Author persistedAuthor;

    @BeforeEach
    void setUp() {
        Book book = new Book("LEK56789","1000 days in desert",20) ;
        Book book2 = new Book("LEK5678454","1 day in desert",20) ;
        Book book3 = new Book("LEK561212","Faith Heaven",20) ;
        Set<Book> bookwritten = new HashSet<Book>();
        bookwritten.add(book);
        bookwritten.add(book2);
        bookwritten.add(book3);
        Author author = new Author("Martin","Jjooga",bookwritten);
        persistedAuthor = em.persist(author);



    }



    @Test
    void create() {
        Book book = new Book("LEK5678932434","Draccco",20) ;
        Book book2 = new Book("LEK5678454d","WEATHER",20) ;
        Book book3 = new Book("LEK561212","CAT FAMILY",20) ;
        Set<Book> bookwritten = new HashSet<Book>();
        bookwritten.add(book);
        bookwritten.add(book2);
        bookwritten.add(book3);
        Author author = new Author("Martin","Jjooga",bookwritten);
        Author result = testObject.create(author);

        assertNotNull(result);
        assertNotNull(result.getWrittenBooks());

    }

    @Test
    void findById() {

        Integer bookId = persistedAuthor.getAuthorId();

        Author result = testObject.findById(bookId);

        assertNotNull(result);
        assertEquals(persistedAuthor, result);
    }

    @Test
    void findAll() {

        int expected = 1;
        Collection<Author> result = testObject.findAll();
        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void update() {

        Author toUpdate = persistedAuthor;
        toUpdate.setFirstName("LL COOL J");
        Author result = testObject.update(toUpdate);
        assertNotNull(result);
        assertEquals("LL COOL J", result.getFirstName());
    }

    @Test
    void delete() {
        assertTrue(testObject.delete(persistedAuthor.getAuthorId()));

    }
}