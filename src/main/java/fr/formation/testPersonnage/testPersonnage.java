package fr.formation.testPersonnage;

import fr.formation.model.*;

public class testPersonnage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage bob = new Knight("Bob",25,Race.HUMAN);
		Personnage paul = new Sorcerer("Paul",25,Race.ELF);
		Personnage alfred = new Priest("Alfred",20,Race.DWARF);
		Equipe equipeA = new Equipe(bob,paul,alfred);
		
		Personnage boby = new Knight("Boby",25,Race.HUMAN);
		boby.setHp(10);
		Personnage pauly = new Sorcerer("Pauly",25,Race.ELF);
		pauly.setHp(10);
		Personnage alfredy = new Priest("Alfredy",20,Race.DWARF);
		alfredy.setHp(10);
		Equipe equipeB = new Equipe(boby,pauly,alfredy);
		
//		System.out.println(bob);
//		bob.attaquer(bob);
//		System.out.println(bob);
		
		
//		Combat C = new Combat(equipeA,equipeB);
//		
//		C.fight();
//		
//		System.out.println(C.getEquipeA().toString());
		
//		int toSend[] = {0,0};
//		toSend = C.demander(bob, equipeA, equipeB);
//		
//		System.out.println(toSend[0]+" "+toSend[1]);
		
		
		

	}
}
