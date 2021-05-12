package fr.formation.java;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.dao.PersonnageDaoHibernate;
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

		PersonnageDaoHibernate pdh = new PersonnageDaoHibernate();
		Personnage Merlin = new Sorcerer("Merlin",80,Race.HUMAN);
		
		Merlin = pdh.add(Merlin);

		ArrayList<Personnage> pl = new ArrayList();
		
		pl = (ArrayList<Personnage>)pdh.findAll();
		
		System.out.println(pl);
		
	}

}
