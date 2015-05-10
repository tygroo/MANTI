package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Criticality;
import fr.apside.sbik.metier.dao.IDaoCriticality;

@Repository
public class DaoCriticality extends AbstractDao<Criticality, Long> implements
		IDaoCriticality {

  @SuppressWarnings("unchecked")
  @Override
  public List<Criticality> getAll() {
    String requete = "SELECT c from Criticality c ORDER BY c.name";
    return em.createQuery(requete).getResultList();
  }
  
}
