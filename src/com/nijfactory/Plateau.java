package com.nijfactory;

public class Plateau {
	// Attributs
	private int ligne = 6;
	private int colonne = 7;
	private String[][] myTab;
	// Constructeur
	Plateau() {
		myTab = new String[this.ligne][this.colonne];
		initialisatonTableau("_");
	}
	// Méthodes
	public int getLigne(){
		return myTab.length;
	}
	
	public int getColonne(){
		return myTab[0].length;
	}
	
	public void setValeur(int ligne, int colonne, String str) {
		myTab[ligne][colonne] = str;
	}
	
	public String getValeur(int ligne, int colonne) {
		return myTab[ligne][colonne];
	}
	
	
	public void initialisatonTableau(String str) {
		for (int i = 0 ; i < this.getLigne(); i++) {
			for (int j = 0; j < this.getColonne(); j++) {
				this.setValeur(i, j, str);
			}
		}
	}
	public int positionColonne(int pos) {
		int position = -1;
		for (int i = 0; i < myTab.length; i++) {
			if (this.getValeur(i, pos)=="_") {
				position = i;
				break;
			}
		}
		return position;
	}
	public boolean plateauFini() {
		boolean test = true;
		for (int i = 0; i < myTab[0].length; i++) {
			if (positionColonne(i)!= -1) {
				test = false;
				break;
			} 
		}
		return test;
	}
	public boolean verifGagne(int v_ligne, int v_colonne) {
		int sommeLigne = 0, sommeColonne = 0, sommeDiagDroite = 0, sommeDiagGauche = 0;
		int i;
		String jeton = myTab[v_ligne][v_colonne];
		boolean testMethode = false;
		// vérifie la ligne
		for(i= v_colonne-1 ; i >= 0 ; i--) {
			if(myTab[v_ligne][i] == jeton) {
				sommeLigne +=1;
			}else {
				break;
			}
		}
		for(i=v_colonne; i < this.colonne; i++) {
			if(myTab[v_ligne][i] == jeton) {
				sommeLigne +=1;
			}else {
				break;
			}
		}		
		// vérifie la colonne		
		for(i = v_ligne - 1 ; i >= 0 ; i--) {
			if(myTab[i][v_colonne] == jeton) {
				sommeColonne +=1;
			}else {
				break;
			}
		}
		for(i = v_ligne; i < this.ligne; i++) {
			if(myTab[i][v_colonne] == jeton) {
				sommeColonne +=1;
			}else {
				break;
			}
		}		
		// vérifie la Diagonale droite
		i = 0;
		while(v_ligne + i < this.ligne && v_colonne + i < this.colonne && myTab[v_ligne + i][v_colonne + i] == jeton) {
			sommeDiagDroite += 1;
			i++;
		}
		i = -1;
		while(v_ligne + i >= 0 && v_colonne + i >= 0 && myTab[v_ligne + i][v_colonne + i] == jeton) {
			sommeDiagDroite += 1;
			i--;
		}
		// vérifie la Diagonale Gauche
		i = 0;
		while(v_ligne - i >= 0 && v_colonne + i < this.colonne &&myTab[v_ligne - i][v_colonne + i] == jeton) {
			sommeDiagGauche += 1;
			i++;
		}
		i = 1;
		while(v_ligne + i < this.ligne && v_colonne - i >= 0 && myTab[v_ligne + i][v_colonne - i] == jeton) {
			sommeDiagGauche += 1;
			i++;
		}		
		if (sommeLigne == 4 || sommeColonne == 4 || sommeDiagDroite == 4 || sommeDiagGauche ==4 ) { 
			testMethode = true; 
		}
		return testMethode;
	}
}
