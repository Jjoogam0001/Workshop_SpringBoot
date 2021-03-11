package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.AuthorDao;
import com.workshop.lexicon.Data.DetailsDao;
import com.workshop.lexicon.Entity.Author;
import com.workshop.lexicon.Entity.Details;
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

class DetailsDaoImplTest {

    @Autowired
    private DetailsDao testObject;
    @Autowired private TestEntityManager em;

    private Details persistedDetails;




    @BeforeEach
    void setUp() {
        Details details = new Details("Jjoogam@gmail.com","Martin Jjooga", LocalDate.parse("1996-09-05"));
        persistedDetails = em.persistAndFlush(details);

    }

    @AfterEach
    void tearDown() {
        em.flush();

    }


    @Test
    void create() {
        Details details = new Details("Jjoogam@gmail.com","Martin Jjooga", LocalDate.parse("1996-09-05"));
        Details result = testObject.create(details);
        assertNotNull(result);
        assertNotNull(result.getEmail());


    }

    @Test
    void findById() {
        Integer detaiId = persistedDetails.getDetaildId();
        Details result = testObject.findById(detaiId);
        assertNotNull(result);
        assertEquals(persistedDetails, result);
    }

    @Test
    void findAll() {
        int expected = 1;
        Collection<Details> result = testObject.findAll();
        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void update() {
        Details toUpdate = persistedDetails;
        toUpdate.setName("LL COOL J");
        Details result = testObject.update(toUpdate);
        assertNotNull(result);
        assertEquals("LL COOL J", result.getName());
    }

    @Test
    void delete() {
        assertTrue(testObject.delete(persistedDetails.getDetaildId()));

    }
}