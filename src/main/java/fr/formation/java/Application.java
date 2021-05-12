package fr.formation.java;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Priest;
import fr.formation.model.Race;
import fr.formation.model.Sorcerer;
import fr.formation.service.PersonnageService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BddProjetUnit");

		// R�cup�rer un EntityManager
		EntityManager em = emf.createEntityManager();

		PersonnageService ps = new PersonnageService();
		
//		Personnage Francois = new Priest("François",90,Race.HUMAN);
//		Personnage Gandalf = new Sorcerer("Gandalf",99999,Race.HUMAN);
//		Personnage Gimli = new Knight("Gimli",100,Race.DWARF);
		Personnage test;
		
//		ps.add(Gimli);
//		ps.add(Gandalf);
//		ps.add(Francois);
		test = ps.findById(11);
		
		System.out.println(test);
		System.out.println(test.getId());
		
	}

}
