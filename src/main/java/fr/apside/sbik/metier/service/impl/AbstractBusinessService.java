package fr.apside.sbik.metier.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.apside.sbik.entity.IEntity;
import fr.apside.sbik.metier.dao.IDao;
import fr.apside.sbik.metier.service.IBusinessService;

public abstract class AbstractBusinessService<T extends IEntity<PK>, PK> implements IBusinessService<T, PK> {

	protected IDao<T, PK> dao;

	@Override
	@Transactional(readOnly = true)
	public T get(PK id) {
		return dao.get(id);
	}

	@Override
	@Transactional
	public void add(T item) {
		dao.add(item);
	}

	@Override
	@Transactional
	public T update(T item) {
		return dao.update(item);
	}

	@Override
	@Transactional
	public void delete(T item) {
		dao.delete(item);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAll() {
		return dao.getAll();
	}

	protected void setDao(IDao<T, PK> dao) {
		this.dao = dao;
	}

}
