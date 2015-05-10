package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Link;
import fr.apside.sbik.metier.dao.IDaoLink;

@Repository
public class DaoLink extends AbstractDao<Link, Long> implements IDaoLink {

  @SuppressWarnings("unchecked")
  @Override
  public List<Link> getAll() {
    String requete = "SELECT l from Link l ORDER BY l.name";
    return em.createQuery(requete).getResultList();
  }

}
