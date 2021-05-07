package fr.formation.dao;

import java.util.ArrayList;
import java.util.Optional;

import fr.formation.model.Priest;

public interface IPriestDao extends IDao<Priest>{
	public ArrayList<Priest> getAll();
	public Optional<Priest> getById(int id);
	public void update(Priest priest);
	public void add(Priest priest);
}
