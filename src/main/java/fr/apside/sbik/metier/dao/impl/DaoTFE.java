package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.TFE;
import fr.apside.sbik.metier.dao.IDaoTFE;

@Repository
public class DaoTFE extends AbstractDao<TFE, Long> implements IDaoTFE {

  @Override
  public List<TFE> getTFEsByBuildingId(Long buildingId) {
    String jpql = "FROM TFE t WHERE t.building.id = :buildingId ORDER BY t.name ASC";
    return em.createQuery(jpql, TFE.class).setParameter("buildingId", buildingId).getResultList();
  }

}
