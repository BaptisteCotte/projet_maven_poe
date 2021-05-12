package fr.formation.service;

import java.util.List;
import java.util.Optional;

import fr.formation.dao.PersonnageDaoHibernate;
import fr.formation.model.Personnage;


public class PersonnageService {

	private PersonnageDaoHibernate pdh = new PersonnageDaoHibernate();
	
	public List<Personnage> findAll(){
		return this.pdh.findAll();
	}
	
	public Personnage findById(int id) {
		Optional<Personnage> op = this.pdh.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Personnage add(Personnage entity) {
		return this.pdh.add(entity);
	}
	
	public Personnage update(Personnage entity) {
		return this.pdh.update(entity);
	}
	
	
}
