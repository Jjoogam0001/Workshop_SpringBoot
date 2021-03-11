package com.workshop.lexicon;

import Data.AuthorDao;
import Entity.Author;
import Entity.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine implements CommandLineRunner {

    private final AuthorDao repo;


    public TestCommandLine(AuthorDao repo) {
        this.repo = repo;

    }


    @Override
    public void run(String... args) {
        Book book1 = new Book(null,"KE34823902302","Hell and Back",30);
        Book book2 = new Book(null,"KE34823902304","Christ Jesus",30);
        Book book3 = new Book(null,"KE34823902307","Holly Mary",30);
        Set<Book> booksWritten = new HashSet<>();
        booksWritten.add(book1);
        booksWritten.add(book2);
        booksWritten.add(book3);
        Author author = repo.save(new Author(null, "Erik", "Svensson", booksWritten));



        System.out.println(author.getAuthorId());

    }
}
