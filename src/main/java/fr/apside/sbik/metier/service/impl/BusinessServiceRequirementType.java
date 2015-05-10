package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.RequirementType;
import fr.apside.sbik.metier.dao.IDaoRequirementType;
import fr.apside.sbik.metier.service.IBusinessServiceRequirementType;

@Service
public class BusinessServiceRequirementType extends AbstractBusinessService<RequirementType, Long> implements IBusinessServiceRequirementType {

	@Resource
	private IDaoRequirementType daoRequirementType;

	@PostConstruct
	public void init() {
		super.setDao(daoRequirementType);
	}

}
