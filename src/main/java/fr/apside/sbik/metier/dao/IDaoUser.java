package fr.apside.sbik.metier.dao;

import fr.apside.sbik.entity.User;

public interface IDaoUser extends IDao<User, String> {

  @Override
  public User get(String username);

}
