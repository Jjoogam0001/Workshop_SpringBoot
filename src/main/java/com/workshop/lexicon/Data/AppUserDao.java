package com.workshop.lexicon.Data;

import com.workshop.lexicon.Entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao  {
    AppUser create(AppUser appUser);
    AppUser findById(Integer appUserId);
    Collection<AppUser> findAll();
    AppUser update(AppUser appUser);
    boolean delete(Integer appUserId);

}
