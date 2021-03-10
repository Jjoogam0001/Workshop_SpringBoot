package Data;

import Entity.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser create(AppUser appUser);
    AppUser findById(Integer appUserId);
    Collection<AppUser> findAll();
    AppUser update(AppUser appUser);
    boolean delete(Integer ingredientid);
}
