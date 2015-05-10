package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Floor;
import fr.apside.sbik.metier.dao.IDaoFloor;

@Repository
public class DaoFloor extends AbstractDao<Floor, Long> implements IDaoFloor {

  @Override
  public List<Floor> getFloorsByBuildingId(Long buildingId) {
    String jpql = "FROM Floor f WHERE f.building.id = :buildingId ORDER BY f.name";
    return em.createQuery(jpql, Floor.class).setParameter("buildingId", buildingId).getResultList();
  }
}
