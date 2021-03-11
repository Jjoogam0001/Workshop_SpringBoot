package Data;

import Entity.BookLoan;
import Entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface DetailsDao extends CrudRepository<Details,Integer> {

    Optional<Details> findByDetailById(Integer id);
}
