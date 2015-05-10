package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.Floor;

public interface IDaoFloor extends IDao<Floor, Long> {

  List<Floor> getFloorsByBuildingId(Long buildingId);

}
