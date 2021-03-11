package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.AppUserDao;
import com.workshop.lexicon.Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    private final EntityManager em;


    @Autowired
    public AppUserDaoImpl(EntityManager em) {
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
                .createQuery("SELECT appusers FROM AppUser appusers", AppUser.class)
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
            throw new IllegalArgumentException("AppUser could not be found");
        }
        toRemove = findById(appUserId);
        return toRemove == null;
    }
}
