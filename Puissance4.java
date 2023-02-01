package fr.iliasse.puissance4;
//TESTTETSTETS
import java.util.Scanner;
import java.util.FilteringMode;

public class Puissance4 {
	
	static int colonne = 7;
	static int ligne = 6;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String[][] plateau = new String[ligne][colonne];
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				plateau[i][j] = ".";
			}
		}
		afficher_plateau(plateau);
		for (int i=0; i<(colonne*ligne)/2; i++) {
			System.out.println("Joueur X : Entrez un nombre entre 0 et 6");
			Scanner sc = new Scanner(System.in);
			int e = sc.nextInt();
			while (e<0 || e>6 || plateau[0][e]!=".") {
				System.out.println("Erreur!! \nJoueur X : Veuillez entrer un nombre entre 0 et 6");
				sc = new Scanner(System.in);
				e = sc.nextInt();
			}
			plateau(plateau, 1, e);
			afficher_plateau(plateau);
			if (combinaison_gagnante(plateau) || egalite(plateau)) {
				System.exit(0);
			}
			System.out.println("Joueur O : Entrez un nombre entre 0 et 6");
			Scanner sc1 = new Scanner(System.in);
			e = sc1.nextInt();
			while (e<0 || e>6 || plateau[0][e]!=".") {
				System.out.println("Erreur!! \nJoueur O : Veuillez entrer un nombre entre 0 et 6");
				sc = new Scanner(System.in);
				e = sc.nextInt();
			}
			plateau(plateau, 2, e);
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
		for (int i=0; i<ligne; i++) {
			System.out.print("|");
			for (int j=0; j<colonne; j++) {
				if (j == colonne - 1) {
					System.out.println(plateau[i][j]+"|");
					continue;
				}
				System.out.print(plateau[i][j]+"|");
			}
			
		}
		System.out.println(" 0 1 2 3 4 5 6 \n");
	} 

	public static boolean combinaison_gagnante(String[][] plateau) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<colonne; j++) {
				if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="X") {
					System.out.println("\nLe joueur X a gagné");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="O") {
					System.out.println("\nLe joueur O a gagné");
					return true;
				}
			}
		}
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<3; j++) {
				if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="X") {
					System.out.println("\nLe joueur X a gagné");
					return true;
				} else if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="O") {
					System.out.println("\nLe joueur O a gagné");
					return true;
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="X") {
					System.out.println("\nLe joueur X a gagné");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="O") {
					System.out.println("\nLe joueur O a gagné");
					return true;
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=6; j<2; j--) {
				if (plateau[i][j]==plateau[i+1][j-1] && plateau[i+1][j-1]==plateau[i+2][j-2] && plateau[i+2][j-2]==plateau[i+3][j-3] && plateau[i+3][j-3]=="X") {
					System.out.println("\nLe joueur X a gagné");
					return true;
				} else if (plateau[i][j]==plateau[i+1][j-1] && plateau[i+1][j-1]==plateau[i+2][j-2] && plateau[i+2][j-2]==plateau[i+3][j-3] && plateau[i+3][j-3]=="O") {
					System.out.println("\nLe joueur O a gagné");
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
		System.out.println("\nEgalité!!!");
		return true;
	}
	
}