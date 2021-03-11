package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.BookDao;
import com.workshop.lexicon.Entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext


class BookDaoImplTest {


    @Autowired
    private BookDao testObject;
    @Autowired private TestEntityManager em;

    private Book persistedBook;

    @BeforeEach
    void setUp() {
        Book unpersisted = new Book("ZEK679912333","Hell AND back",30);
        persistedBook = em.persistAndFlush(unpersisted);
    }

    @AfterEach
    void tearDown() {
        em.flush();
    }

    @Test

    void create() {
        Book book = new Book(
                "ZEK679SA12333","EARTH DAYS",30
        );

        Book result = testObject.create(book);

        assertNotNull(result);
        assertNotNull(result.getTitle());
    }

    @Test
    void findById() {
        Integer bookId = persistedBook.getBookId();

        Book result = testObject.findById(bookId);

        assertNotNull(result);
        assertEquals(persistedBook, result);
    }

    @Test
    void findAll() {
        int expected = 1;
        Collection<Book> result = testObject.findAll();
        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void update() {
        Book toUpdate = persistedBook;
        toUpdate.setIsbn("ZEK124422GH");
        Book result = testObject.update(toUpdate);
        assertNotNull(result);
        assertEquals("ZEK124422GH", result.getIsbn());
    }

    @Test
    void delete() {
        assertTrue(testObject.delete(persistedBook.getBookId()));
    }
}