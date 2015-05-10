package fr.apside.sbik.metier.dao.impl;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Project;
import fr.apside.sbik.metier.dao.IDaoProject;

@Repository
public class DaoProject extends AbstractDao<Project, Long> implements IDaoProject {

}
