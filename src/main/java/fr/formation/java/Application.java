package fr.formation.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BddProjetUnit");

		// Récupérer un EntityManager
		EntityManager em = emf.createEntityManager();

	
	}

}
