package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Unit;
import fr.apside.sbik.metier.dao.IDaoUnit;

@Repository
public class DaoUnit extends AbstractDao<Unit, Long> implements IDaoUnit {

  @SuppressWarnings("unchecked")
  @Override
  public List<Unit> getAll() {
    String requete = "SELECT u from Unit u ORDER BY u.name";
    return em.createQuery(requete).getResultList();
  }

}
