package fr.iliasse.puissance4;

import java.util.Scanner;

public class Puissance4 {
	
	static int colonne = 7;
	static int ligne = 6;
	public static void main(String[] args) {
		String[][] plateau = new String[ligne][colonne];
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				plateau[i][j] = ".";
			}
		}
		for (int i=0; i<(colonne*ligne)/2; i++) {
			System.out.println("Joueur 1 : Entrez un nombre entre 0 et 6");
			Scanner sc = new Scanner(System.in);
			int e = sc.nextInt();
			plateau(plateau, 1, e);
			afficher_plateau(plateau);
			if (combinaison_gagnante(plateau) || egalite(plateau)) {
				System.exit(0);
			}
			System.out.println("Joueur 2 : Entrez un nombre entre 0 et 6");
			Scanner sca = new Scanner(System.in);
			int ee = sc.nextInt();
			plateau(plateau, 2, ee);
			afficher_plateau(plateau);
			if (combinaison_gagnante(plateau) || egalite(plateau)) {
				System.exit(0);
			}
		}
		
	}
	
	public static boolean plateau(String[][] plateau, int joueur, int position_C) {
		int position_L = -1;
		 
		for (int i=ligne-1; i>-1; i--) {
			if ((plateau[i][position_C] == "X") || (plateau[i][position_C] == "O")) {
				continue;
			}
			position_L = i;
			break;
		}
		if (position_L == -1) {
			return true;
		}else {
			if (joueur == 1) {
				plateau[position_L][position_C] = "X";
			} else {
				plateau[position_L][position_C] = "O";
			}
		}
		return false;
		
	}
		
	 
	public static void afficher_plateau(String[][] plateau) {
		//il reste le design
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				if (j == colonne - 1) {
					System.out.println(plateau[i][j]);
					continue;
				}
				System.out.print(plateau[i][j]+" ");
			}
		}
	} 

	public static boolean combinaison_gagnante(String[][] plateau) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<colonne; j++) {
				if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="X") {
					System.out.println("X gagne");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="O") {
					System.out.println("O gagne");
					return true;
				}
			}
		}
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<3; j++) {
				if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="X") {
					System.out.println("X gagne");
					return true;
				} else if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="O") {
					System.out.println("O gagne");
					return true;
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="X") {
					System.out.println("X gagne");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="O") {
					System.out.println("O gagne");
					return true;
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=6; j<2; j--) {
				if (plateau[i][j]==plateau[i+1][j-1] && plateau[i+1][j-1]==plateau[i+2][j-2] && plateau[i+2][j-2]==plateau[i+3][j-3] && plateau[i+3][j-3]=="X") {
					System.out.println("X gagne");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j-1] && plateau[i+1][j-1]==plateau[i+2][j-2] && plateau[i+2][j-2]==plateau[i+3][j-3] && plateau[i+3][j-3]=="O") {
					System.out.println("O gagne");
					return true;
				}
			}
		}
		return false;
		
	}
	
	public static boolean egalite(String[][] plateau) {
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				if (plateau[i][j]==".") {
					return false;
				}
			}
		}
		System.out.println("Egalité!!!");
		return true;
	}
	
}
