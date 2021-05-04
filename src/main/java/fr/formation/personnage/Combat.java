package fr.formation.personnage;

import java.util.Scanner;

public class Combat {

	//Attributs
	protected Equipe EquipeA;
	protected Equipe EquipeB;
	
	//Constructeur
	public Combat(Equipe A,Equipe B) {
		this.EquipeA = A;
		this.EquipeB = B;
	}

	//Accesseurs
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
	
	//Methodes
	public void fight() {
		while(!this.EquipeA.getEquipe().isEmpty() && !this.EquipeB.getEquipe().isEmpty()) {
			for(int i=0; i< this.getEquipeA().getEquipe().size();i++) {
				int demande[] = demander(this.getEquipeA().getEquipe().get(i),this.EquipeA,this.EquipeB);
				
				
			}
		}
	}
	
	
	
	// demande l'action et la cible du personnage de l'utilisateur
	public static int[] demander(Personnage p,Equipe A,Equipe B) {

		boolean actionRealisable = false;
		boolean cibleValide = false;
		Scanner sc = new Scanner(System.in);
		int toSend[] = {0,0};
		int result;
		
		while (!actionRealisable) {
			System.out.println("Quelle action "+p.getName()+" doit il réaliser ?");
			result = sc.nextInt();
			
			switch(result) {
			case 1 :
				actionRealisable = true;
				toSend[0] = 1;
				
				while (!cibleValide) {
					System.out.println("Quelle est la cible de "+p.getName()+" ?");
					result = sc.nextInt();
					
					switch(result) {
					case 1 :
						if(B.getEquipe().size()>=1) {
							toSend[1] = 1;
						}
						cibleValide = true;
					case 2 :
						if(B.getEquipe().size()>=2) {
							toSend[1] = 2;
							cibleValide = true;
						}else {
							System.out.println("Cible invalide");
						}
					case 3 :
						if(B.getEquipe().size()>=3) {
							toSend[1] = 3;
							cibleValide = true;
						}else {
							System.out.println("Cible invalide");
						}
					}
				}		
			case 2 :
				if(p instanceof IHealer) {
					actionRealisable = true;
					toSend[0] = 2;
					
					while (!cibleValide) {
						System.out.println("Quelle est la cible de "+p.getName()+" ?");
						result = sc.nextInt();
						
						switch(result) {
						case 1 :
							toSend[1] = 1;
							cibleValide = true;
						case 2 :
							if(A.getEquipe().size()>=2) {
								toSend[1] = 2;
								cibleValide = true;
							}else {
								System.out.println("Cible invalide");
							}
						case 3 :
							if(A.getEquipe().size()>=3) {
								toSend[1] = 3;
								cibleValide = true;
							}else {
								System.out.println("Cible invalide");
							}
						}
					}
					
				}else {
					System.out.println("Action invalide");
				}
			}
		}
		return toSend;
	}
	//NE PAS OUBLIER LES CAS OU IL N'Y A PAS DE CIBLE DISPONIBLE
}
