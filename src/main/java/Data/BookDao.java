package Data;

import Entity.Book;

import java.util.Collection;

public interface BookDao {

    Book create(Book book);
    Book findById(Book bookId);
    Collection<Book> findAll();
    Book update(Book book);
    boolean delete(Book bookId);

}
