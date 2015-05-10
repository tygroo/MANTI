package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Applicability;
import fr.apside.sbik.metier.dao.IDaoApplicability;

@Repository
public class DaoApplicability extends AbstractDao<Applicability, Long> implements IDaoApplicability {

  @SuppressWarnings("unchecked")
  @Override
  public List<Applicability> getAll() {
    String requete = "SELECT a from Applicability a ORDER BY a.name";
    return em.createQuery(requete).getResultList();
  }

}
