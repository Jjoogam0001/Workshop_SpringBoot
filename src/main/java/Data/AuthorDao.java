package Data;

import Entity.Author;
import org.springframework.data.repository.CrudRepository;



import java.util.Optional;

public interface AuthorDao extends CrudRepository<Author,Integer> {


    Optional<Author> findByAuthorName(String name);

}
