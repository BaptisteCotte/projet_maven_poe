package fr.formation.dao;

import java.util.ArrayList;
import java.util.Optional;
import fr.formation.model.Personnage;

public interface IDao<T> {
	
	public ArrayList<T> getAll();
	public Optional<T> getById(int id);
	public void add(T entity);
	public void update(T entity);
}
