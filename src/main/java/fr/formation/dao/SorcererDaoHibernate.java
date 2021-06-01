package fr.formation.dao;

import java.util.ArrayList;
import java.util.Optional;

import fr.formation.model.Personnage;
import fr.formation.model.Sorcerer;

public class SorcererDaoHibernate extends AbstractDaoHibernate<Sorcerer> implements ISorcererDao{

	public SorcererDaoHibernate() {
		super(Sorcerer.class);
		// TODO Auto-generated constructor stub
	}


}
