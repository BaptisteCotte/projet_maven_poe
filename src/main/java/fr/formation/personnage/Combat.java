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
		
		Scanner sc = new Scanner(System.in);
		int toSend[] = {0,0};
		int result;
		int cible;
		boolean actionRealisable=false;
		boolean ciblePossible = false;
		
		//tant que l'action n'est pas r�alisable 
		while(actionRealisable!=true) {
			
			//je demande quelle action veut il effectuer
			System.out.println("Quelle action "+p.getName()+" doit il r�aliser ?");
			System.out.println("Pour attaquer tapez 1");
			System.out.println("Pour soigner tapez 2");
			System.out.println("Pour passez votre tour tapez 3");
			
			result = sc.nextInt();
			
			//si l'action est attaquer
			if(result == 1 ) {
				actionRealisable=true;	
				toSend[0] = result;
				//tant que la cible n'est pas possible
				while(ciblePossible!=true) {
					
					//je demande qui il veut attaquer
					System.out.println("Qui souhaitez-vous attaquez ? ");
					System.out.println("Pour attaquer :");
					
					for(int i=0;i<B.getEquipe().size();i++) {
						System.out.println(B.getEquipe().get(i).getName() + " tapez " +i);
						}
					
					result = sc.nextInt();
					
					//je verifie si le resultat est inferieur � la taille de l'equipe
					if(result<B.getEquipe().size()) {
						cible=result;
						toSend[1] = cible;
						System.out.println("Vous souhaitez attaquer "+B.getEquipe().get(cible).getName());
						ciblePossible = true;
					}else {
						System.out.println("Vous ne pouvez pas attaquer cette cible.");
					}
				}
			}//si l'action est soigner
			else if(result == 2 && p instanceof IHealer) {
				actionRealisable=true;
				toSend[0] = result;
				while(ciblePossible!=true) {
					
					//je demande qui il veut soigner
					System.out.println("Qui souhaitez-vous soignez ? ");
					System.out.println("Pour soigner :");
					
					for(int i=0;i<A.getEquipe().size();i++) {
						System.out.println(A.getEquipe().get(i).getName() + " tapez " +i);
						}
					
					result = sc.nextInt();
					
					//je verifie si le resultat est inferieur � la taille de l'equipe
					if(result<A.getEquipe().size()) {
						cible=result;
						toSend[1] = cible;						
						System.out.println("Vous souhaitez soigner "+A.getEquipe().get(cible).getName());
						ciblePossible = true;
					}else {
						System.out.println("Vous ne pouvez pas soigner cette cible.");
					}
				}
					
			} //si il souhaite passez son tour
			else if(result == 3){ 
			actionRealisable=true;
			toSend[0] = result;	
			toSend[1] = 0;	
			}//si l'action n'existe pas 
			else {
				System.out.println("L'action n'est pas r�alisable, Rappel:  Si vous souhaitez attaquer : 1 si vous souhaitez soigner 2 :");
			}
		}


				
		return toSend;
		
		//	boolean actionRealisable = false;
		//	boolean actionPossible = false;
		//	boolean cibleValide = false;
		
		/*	System.out.println("Quelle action "+p.getName()+" doit il r�aliser ?");
		result = sc.nextInt();
		switch(result) {
			case 1 : 
				actionPossible= true;
				toSend[0]=1;
				
				
		}
		
		
	/**	while (!actionRealisable) {
			System.out.println("Quelle action "+p.getName()+" doit il r�aliser ?");
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
		}**/
		
	}
	//NE PAS OUBLIER LES CAS OU IL N'Y A PAS DE CIBLE DISPONIBLE
}
