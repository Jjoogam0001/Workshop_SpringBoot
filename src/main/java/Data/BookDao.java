package Data;

import Entity.Author;
import Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookDao extends CrudRepository<Book,Integer> {

    Optional<Book> findByBookTitle(String name);


}
