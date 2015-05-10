package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Link;
import fr.apside.sbik.metier.dao.IDaoLink;
import fr.apside.sbik.metier.service.IBusinessServiceLink;

@Service
public class BusinessServiceLink extends AbstractBusinessService<Link, Long> implements IBusinessServiceLink {

  @Resource
  private IDaoLink daoLink;

  @PostConstruct
  public void init() {
    super.setDao(daoLink);
  }

}
