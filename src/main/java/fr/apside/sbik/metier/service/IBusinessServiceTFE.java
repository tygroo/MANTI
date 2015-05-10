package fr.apside.sbik.metier.service;

import java.util.List;

import fr.apside.sbik.entity.TFE;

public interface IBusinessServiceTFE extends IBusinessService<TFE, Long> {

  List<TFE> getTFEsByBuildingId(Long buildingId);

}
