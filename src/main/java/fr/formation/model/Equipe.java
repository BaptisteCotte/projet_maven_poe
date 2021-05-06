package fr.formation.model;

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

	@Override
	public String toString() {
		String retour = "Equipe [equipe=";
		if(this.getEquipe().size()>=1) {
			retour= retour + " " + this.getEquipe().get(0).toString();
		}
		if(this.getEquipe().size()>=2) {
			retour = retour + " " + this.getEquipe().get(1).toString();
		}
		if(this.getEquipe().size()==3) {
			retour = retour + " " + this.getEquipe().get(2).toString();
		}
		return retour + " ]";
	}
	
	public void regen() {
		if(!this.getEquipe().isEmpty()) {
			for(int i=0;i < this.getEquipe().size();i++) {
				this.getEquipe().get(i).regen();
			}
		}
	}
	
	
	
	

}
