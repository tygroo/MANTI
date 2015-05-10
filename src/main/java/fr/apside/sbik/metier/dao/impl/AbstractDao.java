package fr.apside.sbik.metier.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import fr.apside.sbik.entity.IEntity;
import fr.apside.sbik.metier.dao.IDao;

public abstract class AbstractDao<T extends IEntity<PK>, PK> implements IDao<T, PK> {

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericClass() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T get(PK id) {
		return em.find(getGenericClass(), id);
	}

	@Override
	public void add(T item) {
		em.persist(item);
	}

	@Override
	public T update(T item) {
		T itemManaged = em.find(getGenericClass(), item.getId());
		if (itemManaged != null) {
			return em.merge(item);
		} else {
			throw new EntityNotFoundException("The item to update does not exist");
		}
	}

	@Override
	public void delete(T item) {
		String jpql = "delete " + getGenericClass().getSimpleName() + " e where e.id=" + item.getId();
		int numberItemDeleted = em.createQuery(jpql).executeUpdate();
		if (numberItemDeleted == 0) {
			throw new EntityNotFoundException("The item to delete does not exist");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return em.createQuery("from " + getGenericClass().getSimpleName()).getResultList();
	}

}
