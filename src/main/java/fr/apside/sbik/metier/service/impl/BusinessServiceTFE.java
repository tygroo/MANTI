package fr.apside.sbik.metier.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.TFE;
import fr.apside.sbik.metier.dao.IDaoTFE;
import fr.apside.sbik.metier.service.IBusinessServiceTFE;

@Service
public class BusinessServiceTFE extends AbstractBusinessService<TFE, Long> implements IBusinessServiceTFE {

	@Resource
	private IDaoTFE daoTFE;

	@PostConstruct
	public void init() {
		super.setDao(daoTFE);
	}

  @Override
  @Transactional(readOnly = true)
  public List<TFE> getTFEsByBuildingId(Long buildingId) {
    return daoTFE.getTFEsByBuildingId(buildingId);
  }
}
