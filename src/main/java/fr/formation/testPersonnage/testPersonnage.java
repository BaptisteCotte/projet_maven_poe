package fr.formation.testPersonnage;

import fr.formation.personnage.*;

public class testPersonnage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage bob = new Knight("Bob",25,Race.HUMAN);
		Personnage paul = new Sorcerer("Paul",25,Race.ELF);
		Personnage alfred = new Priest("Alfred",20,Race.DWARF);
		Equipe equipeA = new Equipe(bob,paul,alfred);
		
		Personnage boby = new Knight("Boby",25,Race.HUMAN);
		Personnage pauly = new Sorcerer("Pauly",25,Race.ELF);
		Personnage alfredy = new Priest("Alfredy",20,Race.DWARF);
		Equipe equipeB = new Equipe(boby,pauly,alfredy);
		
		Combat C = new Combat(equipeA,equipeB);
		int toSend[] = {0,0};
		
		toSend = C.demander(alfred, equipeA, equipeB);
		
		System.out.println(toSend[0]+" "+toSend[1]);
		
		

	}
}
