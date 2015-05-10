package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.IEntity;

public interface IDao<T extends IEntity<PK>, PK> {
	T get(PK id);
	void add(T item);
	T update(T item);
	void delete(T item);
	List<T> getAll();
}
