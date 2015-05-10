package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Maturity;
import fr.apside.sbik.metier.dao.IDaoMaturity;
import fr.apside.sbik.metier.service.IBusinessServiceMaturity;

@Service
public class BusinessServiceMaturity extends AbstractBusinessService<Maturity, Long> implements IBusinessServiceMaturity {

	@Resource
	private IDaoMaturity daoMaturityr;

	@PostConstruct
	public void init() {
		super.setDao(daoMaturityr);
	}

}
