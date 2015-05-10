package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Applicability;
import fr.apside.sbik.metier.dao.IDaoApplicability;
import fr.apside.sbik.metier.service.IBusinessServiceApplicability;

@Service
public class BusinessServiceApplicability extends AbstractBusinessService<Applicability, Long> implements
  IBusinessServiceApplicability {

  @Resource
  private IDaoApplicability daoApplicability;

  @PostConstruct
  public void init() {
    super.setDao(daoApplicability);
  }

}
