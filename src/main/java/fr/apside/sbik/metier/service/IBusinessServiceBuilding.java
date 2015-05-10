package fr.apside.sbik.metier.service;

import java.util.List;

import fr.apside.sbik.entity.Building;

public interface IBusinessServiceBuilding extends IBusinessService<Building, Long> {

  List<Building> getBuildingsByProjectId(Long projectId);

}
