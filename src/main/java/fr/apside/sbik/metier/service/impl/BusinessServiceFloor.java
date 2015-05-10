package fr.apside.sbik.metier.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.Floor;
import fr.apside.sbik.metier.dao.IDaoFloor;
import fr.apside.sbik.metier.service.IBusinessServiceFloor;

@Service
public class BusinessServiceFloor extends AbstractBusinessService<Floor, Long> implements IBusinessServiceFloor {

	@Resource
	private IDaoFloor daoFloor;

	@PostConstruct
	public void init() {
		super.setDao(daoFloor);
	}

  @Override
  @Transactional(readOnly = true)
  public List<Floor> getFloorsByBuildingId(Long buildingId) {
    return daoFloor.getFloorsByBuildingId(buildingId);
  }
}
