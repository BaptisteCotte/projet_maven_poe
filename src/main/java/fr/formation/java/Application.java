package fr.formation.java;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.dao.KnightDaoHibernate;
import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Race;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BddProjetUnit");

		// R�cup�rer un EntityManager
		EntityManager em = emf.createEntityManager();

		KnightDaoHibernate kdh = new KnightDaoHibernate();
		List<Knight> listKnight = kdh.findAll();
		System.out.println(listKnight);

	}

}
