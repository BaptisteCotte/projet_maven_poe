package fr.formation.dao;

import fr.formation.model.Personnage;

public class PersonnageDaoHibernate extends AbstractDaoHibernate<Personnage> implements IPersonnageDao {

	public PersonnageDaoHibernate() {
		super(Personnage.class);
	}
}
