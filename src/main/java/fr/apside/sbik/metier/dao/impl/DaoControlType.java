package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.ControlType;
import fr.apside.sbik.metier.dao.IDaoControlType;

@Repository
public class DaoControlType extends AbstractDao<ControlType, Long> implements IDaoControlType {

  @SuppressWarnings("unchecked")
  @Override
  public List<ControlType> getAll() {
    String requete = "SELECT c from ControlType c ORDER BY c.name";
    return em.createQuery(requete).getResultList();
  }
}
