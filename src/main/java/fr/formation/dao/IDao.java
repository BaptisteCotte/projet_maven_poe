package fr.formation.dao;

import java.util.ArrayList;
import java.util.Optional;


public interface IDao<T> {
	
	public ArrayList<T> getAll();
	public Optional<T> getById(int id);
	public void add(T entity);
	public void update(T entity);
}
