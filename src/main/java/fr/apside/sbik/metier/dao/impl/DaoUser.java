package fr.apside.sbik.metier.dao.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.User;
import fr.apside.sbik.metier.dao.IDaoUser;

@Repository
public class DaoUser extends AbstractDao<User, String> implements IDaoUser {

  @Override
  public User get(String username) {
    return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
      .setParameter("username", Long.valueOf(1)).getSingleResult();
  }
  
  @Override
  public void delete(User user) {
    String jpql = "DELETE FROM User u where u.username = :username";
    int numberItemDeleted = em.createQuery(jpql).setParameter("username", user.getUsername()).executeUpdate();
    if (numberItemDeleted == 0) {
      throw new EntityNotFoundException("The user to delete does not exist");
    }
  }

}
