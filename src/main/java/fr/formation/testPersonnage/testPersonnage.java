package fr.formation.testPersonnage;

import fr.formation.model.*;

import java.util.ArrayList;
import java.util.Optional;

import fr.formation.dao.*;

public class testPersonnage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage bob = new Knight("Bob", 25, Race.HUMAN);
		Personnage paul = new Sorcerer("Paul", 25, Race.ELF);
		Personnage alfred = new Priest("Alfred", 20, Race.DWARF);
		Equipe equipeA = new Equipe(bob, paul, alfred);

		Personnage boby = new Knight("Boby", 25, Race.HUMAN);
		boby.setHp(10);
		Personnage pauly = new Knight("Pauly", 25, Race.ELF);
		pauly.setHp(10);
		Personnage alfredy = new Priest("Alfredy", 20, Race.DWARF);
		alfredy.setHp(10);
		Equipe equipeB = new Equipe(boby, pauly, alfredy);
		
	}
}
