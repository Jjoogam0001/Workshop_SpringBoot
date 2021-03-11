package com.workshop.lexicon.Data;

import com.workshop.lexicon.Entity.BookLoan;
import com.workshop.lexicon.Entity.Details;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DetailsDao {
    Details create(Details details);
    Details findById(Integer detailsId);
    Collection<Details> findAll();
    Details update(Details details);
    boolean delete(Integer detailsId);


}
