package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.BookDao;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}