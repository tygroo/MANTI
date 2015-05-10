package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.Project;
import fr.apside.sbik.metier.dao.IDaoProject;
import fr.apside.sbik.metier.service.IBusinessServiceProject;

@Service
public class BusinessServiceProject extends AbstractBusinessService<Project, Long> implements IBusinessServiceProject {

	@Resource
	private IDaoProject daoProject;

	@PostConstruct
	public void init() {
		super.setDao(daoProject);
	}

}
