package Data;

import Entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao extends CrudRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);

}
