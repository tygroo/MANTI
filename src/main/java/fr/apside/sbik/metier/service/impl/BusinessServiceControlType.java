package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.ControlType;
import fr.apside.sbik.metier.dao.IDaoControlType;
import fr.apside.sbik.metier.service.IBusinessServiceControlType;

@Service
public class BusinessServiceControlType extends AbstractBusinessService<ControlType, Long> implements IBusinessServiceControlType {

	@Resource
	private IDaoControlType daoControlType;

	@PostConstruct
	public void init() {
		super.setDao(daoControlType);
	}

}
