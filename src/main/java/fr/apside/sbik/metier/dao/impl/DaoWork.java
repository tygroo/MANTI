package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Work;
import fr.apside.sbik.metier.dao.IDaoWork;

@Repository
public class DaoWork extends AbstractDao<Work, Long> implements IDaoWork {

  @SuppressWarnings("unchecked")
  @Override
  public List<Work> getAll() {
    String requete = "SELECT w from Work w ORDER BY w.name";
    return em.createQuery(requete).getResultList();
  }

}
