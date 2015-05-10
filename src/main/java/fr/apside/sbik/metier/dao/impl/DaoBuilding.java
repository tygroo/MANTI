package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Building;
import fr.apside.sbik.metier.dao.IDaoBuilding;

@Repository
public class DaoBuilding extends AbstractDao<Building, Long> implements IDaoBuilding {

  @Override
  @SuppressWarnings("unchecked")
  public List<Building> getAll() {
    String requete = "SELECT distinct b from Building b LEFT JOIN FETCH b.tfes LEFT JOIN FETCH b.floors f LEFT JOIN FETCH f.rooms ORDER BY b.name";
    return em.createQuery(requete).getResultList();
  }

  @Override
  public List<Building> getBuildingsByProjectId(Long projectId) {
    String jpql = "from Building b where b.project.id=" + projectId;
    return em.createQuery(jpql, Building.class).getResultList();
  }
}
