package fr.formation.java;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.dao.SorcererDaoHibernate;
import fr.formation.model.Personnage;
import fr.formation.model.Race;
import fr.formation.model.Sorcerer;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BddProjetUnit");

		// R�cup�rer un EntityManager
		EntityManager em = emf.createEntityManager();

		SorcererDaoHibernate sdh = new SorcererDaoHibernate();

		Personnage kevin = new Sorcerer();
		
		kevin = sdh.findById(21).get();
		
		kevin.setAge(60);
		
		sdh.update((Sorcerer)kevin);
		

	}

}
