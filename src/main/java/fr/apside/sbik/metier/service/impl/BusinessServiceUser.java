package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.User;
import fr.apside.sbik.metier.dao.IDaoUser;
import fr.apside.sbik.metier.service.IBusinessServiceUser;

@Service
public class BusinessServiceUser extends AbstractBusinessService<User, String> implements IBusinessServiceUser {

  @Resource
  private IDaoUser daoUser;

  @PostConstruct
  public void init() {
    super.setDao(daoUser);
  }
  
  @Override
  public void delete(User user) {
    daoUser.delete(user);
  }

}
