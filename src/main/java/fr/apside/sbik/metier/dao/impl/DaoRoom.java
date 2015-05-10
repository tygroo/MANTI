package fr.apside.sbik.metier.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.apside.sbik.entity.Room;
import fr.apside.sbik.metier.dao.IDaoRoom;

@Repository
public class DaoRoom extends AbstractDao<Room, Long> implements IDaoRoom {

  @Override
  public List<Room> getRoomsByFloorId(Long floorId) {
    String jpql = "FROM Room r WHERE r.floor.id = :floorId ORDER BY r.name";
    return em.createQuery(jpql, Room.class).setParameter("floorId", floorId).getResultList();
  }
}
