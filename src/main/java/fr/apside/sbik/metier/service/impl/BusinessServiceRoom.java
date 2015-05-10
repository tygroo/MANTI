package fr.apside.sbik.metier.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.Room;
import fr.apside.sbik.metier.dao.IDaoRoom;
import fr.apside.sbik.metier.service.IBusinessServiceRoom;

@Service
public class BusinessServiceRoom extends AbstractBusinessService<Room, Long> implements IBusinessServiceRoom {

	@Resource
	private IDaoRoom daoRoom;

	@PostConstruct
	public void init() {
		super.setDao(daoRoom);
	}

  @Override
  @Transactional(readOnly = true)
  public List<Room> getRoomsByFloorId(Long floorId) {
    return daoRoom.getRoomsByFloorId(floorId);
  }
}
