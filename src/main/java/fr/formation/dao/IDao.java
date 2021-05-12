package fr.formation.dao;


import java.util.List;
import java.util.Optional;


public interface IDao<T> {
	
	public List<T> findAll();
	public Optional<T> findById(int id);
	public T add(T entity);
	public T update(T entity);
	public boolean deleteById(int id);
	
}
