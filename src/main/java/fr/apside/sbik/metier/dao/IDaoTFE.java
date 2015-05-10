package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.TFE;

public interface IDaoTFE extends IDao<TFE, Long> {

  List<TFE> getTFEsByBuildingId(Long buildingId);

}
