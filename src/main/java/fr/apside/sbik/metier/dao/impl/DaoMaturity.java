package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Maturity;
import fr.apside.sbik.metier.dao.IDaoMaturity;

@Repository
public class DaoMaturity extends AbstractDao<Maturity, Long> implements IDaoMaturity {

  @SuppressWarnings("unchecked")
  @Override
  public List<Maturity> getAll() {
    String requete = "SELECT m from Maturity m ORDER BY m.name";
    return em.createQuery(requete).getResultList();
  }

}
