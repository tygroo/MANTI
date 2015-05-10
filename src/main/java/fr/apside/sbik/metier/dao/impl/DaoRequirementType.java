package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.RequirementType;
import fr.apside.sbik.metier.dao.IDaoRequirementType;

@Repository
public class DaoRequirementType extends AbstractDao<RequirementType, Long> implements
  IDaoRequirementType {

  @SuppressWarnings("unchecked")
  @Override
  public List<RequirementType> getAll() {
    String requete = "SELECT rt from RequirementType rt ORDER BY rt.name";
    return em.createQuery(requete).getResultList();
  }

}
