package com.workshop.lexicon.Service;

import com.workshop.lexicon.Data.DetailsDao;
import com.workshop.lexicon.Entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao {

    private final EntityManager em;


    @Autowired
    public DetailsDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Details create(Details details) {
        em.persist(details);
        return details;
    }

    @Override
    @Transactional(readOnly = true)
    public Details findById(Integer detailsId) {
        return em.find(Details.class,detailsId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return em
                .createQuery("SELECT details FROM Details details", Details.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Details update(Details details) {
        return em.merge(details);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer detailsId) {
        Details toRemove = findById(detailsId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("Details could not be found");
        }
        toRemove = findById(detailsId);
        return toRemove == null;
    }
}
