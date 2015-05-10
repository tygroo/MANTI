package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Criticality;
import fr.apside.sbik.metier.dao.IDaoCriticality;
import fr.apside.sbik.metier.service.IBusinessServiceCriticality;

@Service
public class BusinessServiceCriticality extends AbstractBusinessService<Criticality, Long> implements IBusinessServiceCriticality {

	@Resource
	private IDaoCriticality daoCriticality;

	@PostConstruct
	public void init() {
		super.setDao(daoCriticality);
	}

}
