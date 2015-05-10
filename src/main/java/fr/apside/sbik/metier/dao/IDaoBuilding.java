package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.Building;

public interface IDaoBuilding extends IDao<Building, Long> {

  List<Building> getBuildingsByProjectId(Long projectId);

}
