package fr.apside.sbik.metier.dao.impl;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.UserRole;
import fr.apside.sbik.metier.dao.IDaoUserRole;

@Repository
public class DaoUserRole extends AbstractDao<UserRole, Integer> implements IDaoUserRole {

}
