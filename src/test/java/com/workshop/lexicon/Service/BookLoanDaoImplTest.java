package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.AuthorDao;
import com.workshop.lexicon.Data.BookDao;
import com.workshop.lexicon.Data.BookLoanDao;
import com.workshop.lexicon.Entity.*;
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

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext

class BookLoanDaoImplTest {



    @Autowired
    private BookLoanDao testObject;
    @Autowired private TestEntityManager em;

    private BookLoan persisteBookLoan;




    @BeforeEach
    void setUp() {
        Details details = new Details("Jjoogam@gmail.com","Martin Jjooga", LocalDate.parse("1996-09-05"));
        AppUser borrower  = new AppUser("kHALED1234","nAMAGELA123",LocalDate.parse("1997-08-09"),details);
        Book book = new Book(
                "ZEK679SA12333","EARTH DAYS",30
        );

        BookLoan bookLoan = new BookLoan(LocalDate.parse("2007-08-12"),true,borrower,book);
        persisteBookLoan = em.persist(bookLoan);


    }



    @Test
    void create() {
        Details details = new Details("Jjoogam@gmail.com","Martin Jjooga", LocalDate.parse("1996-09-05"));
        AppUser borrower  = new AppUser("kHALED1234","nAMAGELA123",LocalDate.parse("1997-08-09"),details);
        Book book = new Book(
                "ZEK679SA12333","EARTH DAYS",30
        );

        BookLoan bookLoan = new BookLoan(LocalDate.parse("2007-08-12"),true,borrower,book);

        BookLoan result = testObject.create(bookLoan);

        assertNotNull(result);
        assertNotNull(result.getBorrower());



    }

    @Test
    void findById() {
        Integer bookLoanId = persisteBookLoan.getLoadId();

        BookLoan result = testObject.findById(bookLoanId);
        assertNotNull(result);
        assertEquals(persisteBookLoan, result);

    }

    @Test
    void findAll() {
        int expected = 1;
        Collection<BookLoan> result = testObject.findAll();
        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void update() {
        BookLoan toUpdate = persisteBookLoan;
        toUpdate.setReturned(false);
        BookLoan result = testObject.update(toUpdate);
        assertNotNull(result);
        assertEquals(false, result.isReturned());

    }

    @Test
    void delete() {
        assertTrue(testObject.delete(persisteBookLoan.getLoadId()));
    }
}