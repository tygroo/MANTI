package fr.apside.sbik.metier.service;

import java.util.List;

public interface IBusinessService<T, PK> {

	T get(PK id);

	void add(T item);

	T update(T item);

	void delete(T item);

	List<T> getAll();

}
