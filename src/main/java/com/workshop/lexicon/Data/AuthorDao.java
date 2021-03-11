package com.workshop.lexicon.Data;

import com.workshop.lexicon.Entity.Author;
import org.springframework.data.repository.CrudRepository;


import java.util.Collection;
import java.util.Optional;

public interface AuthorDao  {


    Author create(Author author);
    Author findById(Integer authorId);
    Collection<Author> findAll();
    Author update(Author author);
    boolean delete(Integer authorId);

}
