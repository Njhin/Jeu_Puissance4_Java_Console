package com.nijfactory;

import java.util.Scanner;

public class Puissance4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		MessageJeu messageJeu =new MessageJeu();
		Plateau plateau = new Plateau();

		String[] jetonJoueur = {"R", "J"};
		int joueurActif = 0;
		
		int colonneJoue = -1, mode = -1, ligneJoue = -1;
		boolean positionOk, reponseOK, partieGagne;
		
		// Programme
		messageJeu.afficheTitle();
		
		// Choix du mode
		reponseOK = false;
		partieGagne = false;
		messageJeu.afficheQuestionMode();
		
		while(reponseOK == false) {
			mode= -1;
			String strTempMode = scanner.nextLine();
			try {
				mode = Integer.valueOf(strTempMode);
				if(mode == 1) {
					reponseOK = true;
				} else if (mode == 2 || mode ==3){
					messageJeu.afficheErreurMode(1);
				} else {
					messageJeu.afficheErreurMode(2);				
				}
			} catch (Exception e) {
				messageJeu.afficheErreurMode(2);
			}
		}

		messageJeu.afficheRegle();

		do {

			// Saisie clavier			
			messageJeu.afficheQuestionSaisie(jetonJoueur[joueurActif]);
			positionOk = false;
			
			while(positionOk == false) {

				colonneJoue= -1;
				String strTemp = scanner.nextLine();

				try {
					colonneJoue = Integer.valueOf(strTemp);
					ligneJoue = plateau.positionColonne(colonneJoue - 1);
					if (colonneJoue >= 1 && colonneJoue <= plateau.getColonne() ) {
						if (ligneJoue == -1) {
							messageJeu.afficheErreurSaisie(1);
						} else {
							positionOk = true;
						}
					} else {
						messageJeu.afficheErreurSaisie(2);
					}
				} catch (Exception e) {
					messageJeu.afficheErreurSaisie(2);
				}
			}
			plateau.setValeur(plateau.positionColonne(colonneJoue - 1), colonneJoue - 1, jetonJoueur[joueurActif]);
			messageJeu.afficheTableau(plateau);			
			partieGagne = plateau.verifGagne(ligneJoue, colonneJoue - 1);
			
			if (partieGagne == false) {
				joueurActif = (joueurActif+ 1) % 2;				
			}			
		} while (plateau.plateauFini() == false && partieGagne == false);
		messageJeu.afficheResultatPartie(partieGagne, joueurActif, jetonJoueur[joueurActif]);	
		scanner.close();
	}
}
