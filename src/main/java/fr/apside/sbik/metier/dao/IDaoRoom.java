package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.Room;

public interface IDaoRoom extends IDao<Room, Long> {

  List<Room> getRoomsByFloorId(Long floorId);

}
