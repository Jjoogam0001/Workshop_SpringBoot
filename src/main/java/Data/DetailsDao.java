package Data;

import Entity.Details;

import java.util.Collection;

public interface DetailsDao {

    Details create(Details details);
    Details findById(Integer detailId);
    Collection<Details> findAll();
    Details update(Details details);
    boolean delete(Integer details);
}
