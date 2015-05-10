package fr.apside.sbik.metier.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.Requirement;
import fr.apside.sbik.metier.dao.IDaoRequirement;
import fr.apside.sbik.metier.service.IBusinessServiceRequirement;

@Service
public class BusinessServiceRequirement extends AbstractBusinessService<Requirement, Long> implements
  IBusinessServiceRequirement {

  @Resource
  private IDaoRequirement daoRequirement;

  @PostConstruct
  public void init() {
    super.setDao(daoRequirement);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Requirement> getRequirementsByProjectId(Long projectId) {
    return daoRequirement.getRequirementsByProjectId(projectId);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Requirement> getActiveRequirementsByProjectId(Long projectId) {
    return daoRequirement.getActiveRequirementsByProjectId(projectId);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Requirement> getFixedRequirementsByProjectId(Long projectId) {
    return daoRequirement.getFixedRequirementsByProjectId(projectId);
  }

  @Override
  @Transactional
  public void insertRequirements() {
    daoRequirement.insertRequirements();
  }

}
