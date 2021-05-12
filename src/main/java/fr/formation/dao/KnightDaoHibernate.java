package fr.formation.dao;

import java.util.ArrayList;
import java.util.Optional;

import fr.formation.model.Knight;


public class KnightDaoHibernate extends AbstractDaoHibernate<Knight> implements IKnightDao {
	
	public KnightDaoHibernate() {
		super(Knight.class);
	}

}
