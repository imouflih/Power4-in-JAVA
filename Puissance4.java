package fr.iliasse.puissance4;

public class Puissance4 {
	
	static int colonne = 7;
	static int ligne = 6;
	static int comb_gagnante = 4;
	public static void main(String[] args) {
		String[][] plateau = new String[ligne][colonne];
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				plateau[i][j] = ".";
			}
		}
		plateau(plateau, 1, 5);
		plateau(plateau, 1, 5);
		plateau(plateau, 2, 5);
		plateau(plateau, 2, 4);
		plateau(plateau, 2, 1);
		afficher_plateau(plateau);
		System.out.println("");
		
	}
	
	public static void plateau(String[][] plateau, int joueur, int position_C) {
		int position_L = -1;
		 
		for (int i=ligne-1; i>-1; i--) {
			if ((plateau[i][position_C] == "X") || (plateau[i][position_C] == "O")) {
				continue;
			}
			position_L = i;
			break;
		}
		if (position_L == -1) {
			System.out.println("Il n'y a plus de case vide dans cette colonne choisit une autre!!");
		}else {
			if (joueur == 1) {
				plateau[position_L][position_C] = "X";
			} else {
				plateau[position_L][position_C] = "O";
			}
		}
		
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

	public static void combinaison_gagnante(String[][] plateau) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<colonne; j++) {
				if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="X") {
					System.out.println("X gagne");
					break;
				} else if (plateau[i][j]==plateau[i+1][j] && plateau[i+1][j]==plateau[i+2][j] && plateau[i+2][j]==plateau[i+3][j] && plateau[i+3][j]=="O") {
					System.out.println("O gagne");
					break;
				}
			}
		}
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<3; j++) {
				if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="X") {
					System.out.println("X gagne");
					break;
				} else if (plateau[i][j]==plateau[i][j+1] && plateau[i][j+1]==plateau[i][j+2] && plateau[i][j+2]==plateau[i][j+3] && plateau[i][j+3]=="O") {
					System.out.println("O gagne");
					break;
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="X") {
					System.out.println("X gagne");
					break;
				} else if (plateau[i][j]==plateau[i+1][j+1] && plateau[i+1][j+1]==plateau[i+2][j+2] && plateau[i+2][j+2]==plateau[i+3][j+3] && plateau[i+3][j+3]=="O") {
					System.out.println("O gagne");
					break;
				}
			}
		}
		for (int i=5; i>2; i--) {
			for (int j=6; j<2; j--) {
				if (plateau[i][j]==plateau[i-1][j-1] && plateau[i-1][j-1]==plateau[i-2][j-2] && plateau[i-2][j-2]==plateau[i-3][j-3] && plateau[i-3][j-3]=="X") {
					System.out.println("X gagne");
					break;
				} else if (plateau[i][j]==plateau[i-1][j-1] && plateau[i-1][j-1]==plateau[i-2][j-2] && plateau[i-2][j-2]==plateau[i-3][j-3] && plateau[i-3][j-3]=="O") {
					System.out.println("O gagne");
					break;
				}
			}
		}
		
	}
	
	public static int egalite(String[][] plateau) {
		for (int i=0; i<ligne; i++) {
			for (int j=0; j<colonne; j++) {
				if (plateau[i][j]==".") {
					return 0;
				}
			}
		}
		System.out.println("Egalité!!!");
		return 1;
	}
	
}