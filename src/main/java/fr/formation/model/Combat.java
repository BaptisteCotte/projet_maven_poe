package fr.formation.model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Combat {

	// Attributs
	protected Equipe EquipeA;
	protected Equipe EquipeB;
	protected ArrayList<Personnage> deads = new ArrayList<>();

	// Constructeur
	public Combat(Equipe A, Equipe B) {
		this.EquipeA = A;
		this.EquipeB = B;
	}

	// Accesseurs
	public Equipe getEquipeA() {
		return EquipeA;
	}

	public void setEquipeA(Equipe equipeA) {
		EquipeA = equipeA;
	}

	public Equipe getEquipeB() {
		return EquipeB;
	}

	public void setEquipeB(Equipe equipeB) {
		EquipeB = equipeB;
	}
	
	public ArrayList<Personnage> getDeads() {
		return this.deads;
	}

	public void addDead(Personnage p) {
		this.deads.add(p);
	}

	// Methodes
	public void fight() {
		//Tant qu'aucune des 2 équipes n'est vide
		while (!this.EquipeA.getEquipe().isEmpty() && !this.EquipeB.getEquipe().isEmpty()) {
			this.tour(EquipeA, EquipeB);
			if(!this.getEquipeB().getEquipe().isEmpty()) {
				this.tour(EquipeB, EquipeA);
			}
		}
		
		if(this.EquipeA.getEquipe().isEmpty()) {
			System.out.println("Victoire de l'équipe B");
		}else if(this.EquipeB.getEquipe().isEmpty()) {
			System.out.println("Victoire de l'équipe A");
		}
	}

	
	// demande l'action et la cible du personnage de l'utilisateur
	public static int[] demander(Personnage p, Equipe A, Equipe B) {

		Scanner sc = new Scanner(System.in);
		int toSend[] = { 0, 0 };
		int result;
		int cible;
		boolean actionRealisable = false;
		boolean ciblePossible = false;

		if(!B.getEquipe().isEmpty()) {
			try {
	
				
				// tant que l'action n'est pas r�alisable
				while (actionRealisable != true) {
	
					// je demande quelle action veut il effectuer
					System.out.println("Quelle action " + p.getName() + " doit il r�aliser ?");
					System.out.println("Pour attaquer tapez 1");
					if(p instanceof IHealer) {
						System.out.println("Pour soigner tapez 2");
					}
					System.out.println("Pour passez votre tour tapez 3");
	
					result = sc.nextInt();
	
					// si l'action est attaquer
					if (result == 1) {
						actionRealisable = true;
						toSend[0] = result;
						// tant que la cible n'est pas possible
						while (ciblePossible != true) {
	
							// je demande qui il veut attaquer
							System.out.println("Qui souhaitez-vous attaquez ? ");
							System.out.println("Pour attaquer :");
	
							for (int i = 0; i < B.getEquipe().size(); i++) {
								System.out.println(B.getEquipe().get(i).getName() + " tapez " + i);
							}
	
							result = sc.nextInt();
	
							// je verifie si le resultat est inferieur � la taille de l'equipe
							if (result < B.getEquipe().size()) {
								cible = result;
								toSend[1] = cible;
								System.out.println("Vous souhaitez attaquer " + B.getEquipe().get(cible).getName());
								ciblePossible = true;
							} else {
								System.out.println("Vous ne pouvez pas attaquer cette cible.");
							}
						}
					} // si l'action est soigner
					else if (result == 2 && p instanceof IHealer) {
						actionRealisable = true;
						toSend[0] = result;
						while (ciblePossible != true) {
	
							// je demande qui il veut soigner
							System.out.println("Qui souhaitez-vous soignez ? ");
							System.out.println("Pour soigner :");
	
							for (int i = 0; i < A.getEquipe().size(); i++) {
								System.out.println(A.getEquipe().get(i).getName() + " tapez " + i);
							}
	
							result = sc.nextInt();
	
							// je verifie si le resultat est inferieur � la taille de l'equipe
							if (result < A.getEquipe().size()) {
								cible = result;
								toSend[1] = cible;
								System.out.println("Vous souhaitez soigner " + A.getEquipe().get(cible).getName());
								ciblePossible = true;
							} else {
								System.out.println("Vous ne pouvez pas soigner cette cible.");
							}
						}
	
					} // si il souhaite passez son tour
					else if (result == 3 ) {
						actionRealisable = true;
						toSend[0] = result;
						toSend[1] = 0;
					} // si l'action n'existe pas
					else {
						System.out.println(
								"L'action n'est pas r�alisable, Rappel:  Si vous souhaitez attaquer : 1 si vous souhaitez soigner 2 :");
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("Entrée invalide");
				toSend = demander(p, A, B);
			}
		}
		return toSend;
	}
	
	
	public void tour(Equipe attaquant, Equipe defenseur) {
		//Pour tout les personnage de l'équipe Attaquante
		for (int i = 0; i < attaquant.getEquipe().size(); i++) {
			Personnage p = attaquant.getEquipe().get(i);
			
			if(p instanceof Knight) {
				System.out.println(p.getName()+" est un chevalier");
			}else if(p instanceof Sorcerer) {
				System.out.println(p.getName()+" est un sorcier");
			}else if(p instanceof Priest) {
				System.out.println(p.getName()+" est un pretre");
			}
			
			//On demande l'action a effectuer pour ce personnage
			int demande[] = demander(p, attaquant, defenseur);
			// si demande est attaquer
			if (demande[0] == 1) {
				p.attaquer(defenseur.getEquipe().get(demande[1]));
				if(!defenseur.getEquipe().get(demande[1]).state) {
					this.addDead(defenseur.getEquipe().get(demande[1]));
					defenseur.getEquipe().remove(demande[1]);
				}
			} else if (demande[0] == 2) {
				IHealer pHealer = (IHealer) p;
				pHealer.heal(attaquant.getEquipe().get(demande[1]));
			} else if (demande[0] == 0){
			} else if (demande[0] == 3) {
				System.out.println("Vous avez pass� votre tour");
			}
			
		}
	}
	
	public void regen() {
		this.getEquipeA().regen();
		this.getEquipeB().regen();
	}
}
