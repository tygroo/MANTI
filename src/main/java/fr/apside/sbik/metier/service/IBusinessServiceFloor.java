package fr.apside.sbik.metier.service;

import java.util.List;

import fr.apside.sbik.entity.Floor;

public interface IBusinessServiceFloor extends IBusinessService<Floor, Long> {

  List<Floor> getFloorsByBuildingId(Long buildingId);

}
