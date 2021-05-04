package fr.formation.personnage;

import java.util.ArrayList;

public class Equipe {
	
	protected ArrayList<Personnage> equipe;
	
	public Equipe(Personnage A,Personnage B,Personnage C) {
		this.equipe = new ArrayList<>();
		this.equipe.add(A);
		this.equipe.add(B);
		this.equipe.add(C);
	}

	public ArrayList<Personnage> getEquipe() {
		return equipe;
	}

	public void setEquipe(ArrayList<Personnage> equipe) {
		this.equipe = equipe;
	}
	
	

}
