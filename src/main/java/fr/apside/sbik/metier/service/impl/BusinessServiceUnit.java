package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Unit;
import fr.apside.sbik.metier.dao.IDaoUnit;
import fr.apside.sbik.metier.service.IBusinessServiceUnit;

@Service
public class BusinessServiceUnit extends AbstractBusinessService<Unit, Long> implements IBusinessServiceUnit {

	@Resource
	private IDaoUnit daoUnit;

	@PostConstruct
	public void init() {
		super.setDao(daoUnit);
	}

}
