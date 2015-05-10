package fr.apside.sbik.metier.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.apside.sbik.entity.UserRole;
import fr.apside.sbik.metier.dao.IDaoUserRole;
import fr.apside.sbik.metier.service.IBusinessServiceUserRole;

@Service
public class BusinessServiceUserRole extends AbstractBusinessService<UserRole, Integer> implements IBusinessServiceUserRole {

	@Resource
	private IDaoUserRole daoUserUser;

	@PostConstruct
	public void init() {
		super.setDao(daoUserUser);
	}

}
