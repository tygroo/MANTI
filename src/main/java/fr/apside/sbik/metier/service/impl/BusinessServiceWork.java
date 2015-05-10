package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Work;
import fr.apside.sbik.metier.dao.IDaoWork;
import fr.apside.sbik.metier.service.IBusinessServiceWork;

@Service
public class BusinessServiceWork extends AbstractBusinessService<Work, Long> implements IBusinessServiceWork {

	@Resource
	private IDaoWork daoWork;

	@PostConstruct
	public void init() {
		super.setDao(daoWork);
	}

}
