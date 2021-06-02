package fr.formation.service;

import java.util.List;
import java.util.Optional;

import fr.formation.dao.EquipeDaoSql;
import fr.formation.model.Equipe;

public class EquipeService {

private EquipeDaoSql eds = new EquipeDaoSql();
	
	public List<Equipe> findAll(){
		return this.eds.findAll();
	}
	
	public Equipe findById(int id) {
		Optional<Equipe> oe = this.eds.findById(id);
		if(oe.isPresent()) {
			return oe.get();
		}else {
			return null;
		}
	}
	
	public Equipe add(Equipe entity) {
		return this.eds.add(entity);
	}
	
	public void deleteById(int id) {
		
		this.eds.deleteById(id);
		
	}
}
