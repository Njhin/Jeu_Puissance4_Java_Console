package com.nijfactory;

public class MessageJeu {
	private void afficheSeparator(int max) {
		String strSeparator = "";
		for (int i = 0 ; i < max; i++) {
			strSeparator += "*";
		}
		System.out.println(strSeparator);
	}
	public void afficheRegle() {
		String strEspace = "    ";
		afficheSeparator(100);
		
		System.out.println(("Règles du jeu").toUpperCase());
		System.out.println();
		System.out.println(strEspace + "Le but du jeu est d'aligner une suite de 4 pions de même couleur "
				+ "\n" + strEspace + " sur la grille comptant 6 rangées et 7 colonnes.");
		System.out.println(strEspace + "Tour à tour, les deux joueurs placent un pion dans la colonne de leur choix,"
				+ "\n" + strEspace + " le pion coulisse alors jusqu'à la position la plus basse possible dans ladite colonne"
				+ "\n" + strEspace + " à la suite de quoi c'est à l'adversaire de jouer.");
		System.out.println(strEspace + "Le vainqueur est le joueur qui réalise le premier un alignement"
				+ "\n" + strEspace + " (horizontal, vertical ou diagonal) consécutif d'au moins quatre pions de sa couleur.");
		System.out.println(strEspace + "Si, alors que toutes les cases de la grille de jeu sont remplies,"
				+ "\n" + strEspace + " aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle.");
		System.out.println();
		
		afficheSeparator(100);
	}
	public void afficheTitle() {
		System.out.println();
		System.out.println("         *   * ");
		System.out.println("         *   * ");
		System.out.println("         *   * ");
		System.out.println("         *   * ");
		System.out.println("         ***** ");
		System.out.println("             * ");
		System.out.println("  *      *   * ");
		System.out.println("   *    *    * ");
		System.out.println("    *  *     * ");
		System.out.println("     **        ");
		System.out.println("    *  *       ");
		System.out.println("   *    *      ");	
		System.out.println("  *      *     ");
		System.out.println();
	}
	public void afficheTableau(Plateau myTab) {
		System.out.println("Voici l'avancement du plateau :\n");
		for (int i = myTab.getLigne()-1; i >= 0; i--) {
			System.out.print("       ");
			for (int j= 0; j < myTab.getColonne(); j++) {
				if (j==0) {
					System.out.print("|");	
				}
				System.out.print(myTab.getValeur(i, j) + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void afficheQuestionMode() {
		afficheSeparator(100);
		System.out.println("Bienvenue dans le Puissance 4");		
		System.out.println("Mode");	
		System.out.println("[1] - Human vs Human");	
		System.out.println("[2] - Human vs Computer nul");	
		System.out.println("[3] - Human vs Computer pas nul");		
		System.out.print("Veuillez saisir une colonne :");
	}
	public void afficheErreurMode(int result) {
		switch (result) {
			case 1 : 
				System.out.println("Mode, pas encore codé sniff, essayez un autre choix ");
				break;
			default :
				System.out.println("Nombre incorrect, essayez encore : ");
		}
	}
	public void afficheQuestionSaisie(String str) {
		System.out.print("Le joueur "+ str +", veuillez saisir une colonne [1 à 7] : ");
	}
	public void afficheTestTableau(Plateau plateau) {
		System.out.println(
				plateau.positionColonne(0) + "/" +
				plateau.positionColonne(1) + "/" +
				plateau.positionColonne(2) + "/" +
				plateau.positionColonne(3) + "/" +
				plateau.positionColonne(4) + "/" +
				plateau.positionColonne(5) + "/" +
				plateau.positionColonne(6) + "/" +
				plateau.plateauFini()
				);
		
	}
	public void afficheErreurSaisie(int result) {
		switch (result) {
		case 1 : 
			System.out.println("Colonne pleine, essayez encore : ");
			break;
		default :
			System.out.println("Nombre incorrect, essayez encore : ");
		}
	}
	public void afficheResultatPartie(boolean gagnant, int numeroJoueur, String jeton) {
		System.out.println("------------ Fin de partie ---------------");
		if(gagnant == true) {
			System.out.println("Le gagnant est : Le joueur " + (numeroJoueur + 1) +  " possèdant la couleur " + jeton);			
		}else {
			System.out.println("La partie se fini sur une égalité.");						
		}
	}
}
