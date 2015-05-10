package fr.apside.sbik.metier.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.Building;
import fr.apside.sbik.metier.dao.IDaoBuilding;
import fr.apside.sbik.metier.service.IBusinessServiceBuilding;

@Service
public class BusinessServiceBuilding extends AbstractBusinessService<Building, Long> implements IBusinessServiceBuilding {

	@Resource
	private IDaoBuilding daoBuilding;

	@PostConstruct
	public void init() {
		super.setDao(daoBuilding);
	}

  @Override
  @Transactional(readOnly = true)
  public List<Building> getBuildingsByProjectId(Long projectId) {
    return daoBuilding.getBuildingsByProjectId(projectId);
  }
}
