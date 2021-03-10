package Repository;

import Data.AppUserDao;
import Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AppUserRepository implements AppUserDao {

    private final EntityManager em;


    @Autowired
    public AppUserRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser create(AppUser appUser) {
        em.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findById(Integer appUserId) {
        return em.find(AppUser.class,appUserId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return em
                .createQuery("SELECT appUsers FROM AppUser appUsers", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser update(AppUser appUser) {
        return em.merge(appUser);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer appUserId) {
        AppUser toRemove = findById(appUserId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("AppUsers could not be found");
        }
        toRemove = findById(appUserId);
        return toRemove == null;
    }
}
