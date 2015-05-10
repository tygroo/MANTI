package fr.apside.sbik.metier.service;

import java.util.List;

import fr.apside.sbik.entity.Room;

public interface IBusinessServiceRoom extends IBusinessService<Room, Long> {

  List<Room> getRoomsByFloorId(Long floorId);

}
