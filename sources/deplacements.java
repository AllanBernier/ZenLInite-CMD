/**
 * Cette classe plermet de calculer tout les deplacements possible pour un pion en lui envoyant sa couleur, le plateau et sa position
 * @author Allan Bernier
 * @since 18/04/20
 */
public class deplacements
{
	/**
	 * Compte le nombre de pions présent dans la ligne et renvoit cette valeur
	 * @param pMap la map ou sont placé les pions
	 * @param pLigne le placement y de notre pion ( x et y sont inversé à ligne colonne !)
	 * @param pColonne le placement x de notre pion
	 * @return Le nombre de pions présent dans la ligne
	 */
	public static int nbInLigne(int[][] pMap, int pLigne, int pColonne)
	{
		int ret = 0;
		if (pMap != null && pLigne >= 0 && pLigne < 11 && pColonne >= 0 && pColonne < 11)
		{
			
			for (int i = 0; i < 11; i++) // 11 correspond à la taille de la map
			{
				if ( pMap[pLigne][i] != 0 ) // Si il y à un pion sur la ligne
				{
					ret ++; // Le nombre de pions présent augmente de 1
				}
			}
		}
		else
		{
			System.err.println("==Problemes de parametres==");
		}
		return ret;
	}

	/**
	 * Test de la methode nbInLigne
	 */
	public static void testNbInLigne()
	{
		System.out.println("\n======Test de nbInLigne=========\n");
		int tab[][] =  {{1,0,0,0,0,1,0,1,0,0,0},//0
						{0,0,1,0,0,0,0,1,0,1,0},//1
						{0,0,0,0,0,0,0,0,1,0,0},//2
						{1,0,0,0,1,0,0,0,0,0,0},//3
						{0,0,0,0,0,1,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,1,0,0,0,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,1,0,0,0,0,1,0,0,0},//8
						{0,0,0,0,0,0,0,0,0,0,0},//9
						{0,0,0,0,1,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10			
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Ligne " + i + " la methode trouve: "+ nbInLigne(tab,i,0) );
		}
				
		System.out.println("Envoyer null en tant que parametre tableau :"+ nbInLigne(null,3,4) );
		System.out.println("Envoyer 13 en tant que parametre pLigne :"+ nbInLigne(tab,13,4) );

		System.out.println("\n======fin du test=========\n");
	}
	
	/**
	 * Compte le nombre de pions présent dans la colonne et renvoit cette valeur
	 * @param pMap la map ou sont placé les pions
	 * @param pLigne le placement y de notre pion ( x et y sont inversé à ligne colonne !)
	 * @param pColonne le placement x de notre pion
	 * @return Le nombre de pions présent dans la colonne
	 */
	public static int nbInColonne(int[][] pMap, int pLigne, int pColonne)
	{
		int ret = 0;
		if (pMap != null && pLigne >= 0 && pLigne < 11 && pColonne >= 0 && pColonne < 11)
		{
			
			for (int i = 0; i < 11; i++) // 11 correspond à la taille de la map
			{
				if ( pMap[i][pColonne] != 0 ) // Si il y à un pion sur la ligne
				{
					ret ++; // Le nombre de pions présent augmente de 1
				}
			}
		}
		else
		{
			System.err.println("==Problemes de parametres==");
		}
		return ret;
	}
	
	/**
	 * Test de la methode nbInColonne
	 */
	public static void testNbInColonne()
	{
		System.out.println("\n======Test de nbColonne=========\n");
		int tab[][] =  {{1,0,0,0,0,1,0,1,0,0,0},//0
						{0,0,1,0,0,0,0,1,0,1,0},//1
						{0,0,0,0,0,0,0,0,1,0,0},//2
						{1,0,0,0,1,0,0,0,0,0,0},//3
						{0,0,0,0,0,1,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,1,0,0,0,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,1,0,0,0,0,1,0,0,0},//8
						{0,0,0,0,0,0,0,0,0,0,0},//9
						{0,0,0,0,1,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10	
					   
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Colonne " + i + " la methode trouve: "+ nbInColonne(tab,0,i) );
		}
		System.out.println("Envoyer null en tant que parametre tableau :"+ nbInColonne(null,3,4) );
		System.out.println("Envoyer 13 en tant que parametre pLigne :"+ nbInColonne(tab,13,4) );


		System.out.println("\n======fin du test=========\n");

	}

	/**
	 * Compte le nombre de pions présent dans la diagonale de gauche et renvoit cette valeur
	 * (diagonal de gauche CAD de haut gauche jusqu'a bas droite)
	 * @param pMap la map ou sont placé les pions
	 * @param pLigne le placement y de notre pion ( x et y sont inversé à ligne colonne !)
	 * @param pColonne le placement x de notre pion
	 * @return Le nombre de pions présent dans la diagonal
	 */
	public static int nbInDiagonalGauche(int[][] pMap, int pLigne, int pColonne)
	{
		int ret = 0;
		if (pMap != null && pLigne >= 0 && pLigne < 11 && pColonne >= 0 && pColonne < 11)
		{
			int diagonal;
			if (pColonne > pLigne)
			{
				diagonal = pColonne - pLigne; // Numéro de la diagonal
				int nbVal = 11 - diagonal; // nombre de valeurs dans la diagonal
//				System.out.println("nbVal ="+nbVal + "\tdiagonal =" + diagonal ); // Ligne utile seulement pour débug
				for (int i = 0; i < nbVal; i ++) // Pour chaque case de cette diagonal
				{
//					System.out.println("ligne =" + i +"\tColonne ="+ (diagonal + i) + "\tmap[ligne][colonne] =" + pMap[i][diagonal + i] ); // Ligne utile seulement pour débug
					if ( pMap[i][diagonal + i] != 0 ) // Si il y à un pion dedans
					{
						ret ++;
					}
				}
			}
			else
			{
				diagonal = pLigne - pColonne; // Numéro de la diagonal
				int nbVal = 11 - diagonal; // nombre de valeurs dans la diagonal
//				System.out.println("nbVal ="+nbVal + "\tdiagonal =" + diagonal ); // Ligne utile seulement pour débug
				for (int i = 0; i < nbVal; i ++) // Pour chaque case de cette diagonal
				{
//					System.out.println("ligne =" + (diagonal + i) +"\tColonne ="+ i + "\tmap[ligne][colonne] =" + pMap[diagonal + i][i] ); // Ligne utile seulement pour débug
					if ( pMap[diagonal + i][i] != 0 ) // Si il y à un pion dedans
					{
						ret ++;
					}
				}
			}
			
		
		}
		else
		{
			System.err.println("==Problemes de parametres==");
		}
		return ret;
	}

	/**
	 * Test de la methode nbInDiagonalGauche
	 */
	public static void testNbInDiagonalGauche()
	{
		System.out.println("\n======Test de nbInDiagonalGauche=========\n");
		int tab[][] =  {{1,0,0,0,0,1,0,1,0,0,0},//0
						{0,1,1,0,0,0,0,1,0,1,0},//1
						{0,0,1,0,0,0,0,0,1,0,0},//2
						{1,0,0,0,1,0,0,0,0,0,0},//3
						{0,0,0,0,0,1,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,1,0,0,0,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,1,0,0,0,0,1,0,0,0},//8
						{0,0,0,0,0,0,0,0,0,0,0},//9
						{0,0,0,0,1,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10		
					
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Ligne " + i + ", Colonne 0 la methode trouve: "+ nbInDiagonalGauche(tab,i,0) );
		}
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Ligne 0, Colonne " + i + " la methode trouve: "+ nbInDiagonalGauche(tab,0,i) );
		}
		System.out.println("Envoyer null en tant que parametre tableau :"+ nbInDiagonalGauche(null,3,4) );
		System.out.println("Envoyer 13 en tant que parametre pLigne :"+ nbInDiagonalGauche(tab,13,4) );

		System.out.println("\n======fin du test=========\n");

	}
	
	/**
	 * Compte le nombre de pions présent dans la diagonale de gauche et renvoit cette valeur
	 * (diagonal de droite CAD de haut droite jusqu'a bas gauche)
	 * @param pMap la map ou sont placé les pions
	 * @param pLigne le placement y de notre pion ( x et y sont inversé à ligne colonne !)
	 * @param pColonne le placement x de notre pion
	 * @return Le nombre de pions présent dans la diagonal
	 */
	public static int nbInDiagonalDroite(int[][] pMap, int pLigne, int pColonne)
	{
		int ret = 0;
		if (pMap != null && pLigne >= 0 && pLigne < 11 && pColonne >= 0 && pColonne < 11)
		{
			int diagonal;
			if (pLigne + pColonne <= 10 )
			{
				diagonal =10 - (pColonne + pLigne); // Numéro de la diagonal
				int nbVal =11 - diagonal; // nombre de valeurs dans la diagonal
//				System.out.println("nbVal ="+nbVal + "\tdiagonal =" + diagonal ); // Ligne utile seulement pour débug
				for (int i = 0; i < nbVal;i ++)
					{
//					System.out.println("ligne =" + i +"\tColonne ="+  (10-(diagonal + i)) + "\tmap[ligne][colonne] =" + pMap[i][10-(diagonal + i)] ); // Ligne utile seulement pour débug
					if ( pMap[i][10-(diagonal + i)] != 0 )
					{
						ret ++;
					}
				}
			}
			else
			{
				diagonal = (pLigne + pColonne) - 10 ; // Numéro de la diagonal
				int nbVal =11 - diagonal; // nombre de valeurs dans la diagonal
//				System.out.println("nbVal ="+nbVal + "\tdiagonal =" + diagonal ); // Ligne utile seulement pour débug
				for (int i = 0; i < nbVal;i ++)
					{
//					System.out.println("ligne =" + ((10-(nbVal-1)) + i) +"\tColonne ="+  (10 - i) + "\tmap[ligne][colonne] =" + pMap[10-(nbVal-1) + i][10 - i] ); // Ligne utile seulement pour débug
					if ( pMap[(10-(nbVal-1)) + i][10 - i] != 0 )
					{
						ret ++;
					}
				}
			}
		
		}
		else
		{
			System.err.println("==Problemes de parametres==");
		}
		return ret;
	}

	/**
	 * Test de la methode nbInDiagonalDroite
	 */
	public static void testNbInDiagonalDroite()
	{
		System.out.println("\n======Test de NbInDiagonalDroite=========\n");
		int tab[][] =  {{1,0,0,0,0,1,0,1,0,0,0},//0
						{0,0,1,0,0,0,0,1,0,1,0},//1
						{0,0,0,0,0,0,0,0,1,0,0},//2
						{1,0,0,0,1,0,0,0,0,0,0},//3
						{0,0,0,0,0,1,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,1,0,0,0,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,1,0,0,0,0,1,0,0,0},//8
						{0,0,0,0,0,0,0,0,0,0,0},//9
						{0,0,0,0,1,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10		
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Ligne " + i + ", Colonne 0 la methode trouve: "+ nbInDiagonalDroite(tab,i,0) );
		}
		for (int i = 0; i < 11; i++)
		{
			System.out.println("Ligne 10, Colonne " + i + " la methode trouve: "+ nbInDiagonalDroite(tab,10,i) );
		}		
		System.out.println("Envoyer null en tant que parametre tableau :"+ nbInDiagonalDroite(null,3,4) );
		System.out.println("Envoyer 13 en tant que parametre pLigne :"+ nbInDiagonalDroite(tab,13,4) );

		System.out.println("\n======fin du test=========\n");

	}

	/**
	 * Cette methode renvoit un tableau sous la forme 
	 * {l,c,b},{l,c,b}... des 8 la cases ou le pions peut se prétendument se déplacer en ligne et colonne
	 * Ce tableau ne test pas les conditions de sortie de carte ou autres !!
	 * tab[0] correspond au déplacement en ligne vers la haut
	 * tab[1] correspond au déplacement en ligne vers la bas 
	 * tab[2] correspond au déplacement en colonne vers le droite
	 * tab[3] correspond au déplacement en colonne vers le gauche
	 * tab[4] correspond au déplacements en diagonal en haut a gauche
	 * tab[5] correspond au déplacements en diagonal en bas a droite
	 * tab[6] correspond au déplacements en diagonal en haut a droite
	 * tab[7] correspond au déplacements en diagonal en bas a gauche
	 * @param pMap la map servant à récuperer les valeurs
	 * @param pLigne la ligne de position du pion
	 * @param pColonne la colonne de position du pions
	 * @return le tableau de deplacements
	 */
	public static int[][] brutDeplacementsPion(int[][] pMap, int pLigne, int pColonne)
	{
		int ret[][] = new int [8][2];
		int dpInLigne 			= nbInLigne(pMap, pLigne, pColonne);
		int dpInColonne 		= nbInColonne(pMap, pLigne, pColonne);
		int dpInDiagonalGauche	= nbInDiagonalGauche(pMap, pLigne, pColonne);
		int dpInDiagonalDroite	= nbInDiagonalDroite(pMap, pLigne, pColonne);
		
		// Déplacements posible en Ligne pour le pion en pLigne, pColonne
		
		ret[0][0] = pLigne - dpInLigne;
		ret[0][1] = pColonne;
		
		ret[1][0] = pLigne + dpInLigne;
		ret[1][1] = pColonne;

		// Déplacements posible en Colonne pour le pion en pLigne, pColonne
		ret[2][0] = pLigne;
		ret[2][1] = pColonne + dpInColonne;
		
		ret[3][0] = pLigne;
		ret[3][1] = pColonne - dpInColonne;
		
		// Déplacements posible en Diagonal Gauche pour le pion en pLigne, pColonne
		ret[4][0] = pLigne - dpInDiagonalGauche;
		ret[4][1] = pColonne - dpInDiagonalGauche;
		
		ret[5][0] = pLigne + dpInDiagonalGauche;
		ret[5][1] = pColonne + dpInDiagonalGauche;
	
		// Déplacements posible en Diagonal Droite pour le pion en pLigne, pColonne	
		ret[6][0] = pLigne + dpInDiagonalDroite;
		ret[6][1] = pColonne - dpInDiagonalDroite;
		
		ret[7][0] = pLigne - dpInDiagonalDroite;
		ret[7][1] = pColonne + dpInDiagonalDroite;
		
		return ret;
	}

	/**
	 * Test de la methode deplacementsPion
	 */
	public static void testBrutDeplacementsPion()
	{
		System.out.println("\n======Test de deplacementsPion=========\n");
		System.out.println("=Ce test est à verifier graphiquement=");
		int tab[][] =  {{1,0,0,0,0,1,0,1,0,0,0},//0
						{0,0,1,0,0,0,0,1,0,1,0},//1
						{0,0,0,0,0,0,0,0,1,0,0},//2
						{1,0,0,0,1,0,0,0,0,0,0},//3
						{0,0,0,1,0,1,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,1,0,1,0,1,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,1,0,0,0,0,1,0,0,0},//8
						{0,0,0,0,0,1,0,0,0,0,0},//9
						{0,0,0,0,1,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10		
		int move[][] = brutDeplacementsPion(tab, 6, 5);
		
		System.out.println("Pour le pion placé en ligne 6 colonne 5, ses déplacements sont :");
		System.out.println("position initial :[l=6]\t[c=5]");
		
		System.out.println("DiagoG " + nbInDiagonalGauche(tab,6,5));
		System.out.println("DiagoD " + nbInDiagonalDroite(tab,6,5));
		
		for (int i = 0; i < 8; i++)
		{
			System.out.println("\t[l=" + move[i][0] + "]\t[c=" + move[i][1] + "]");
			if ( i % 2 != 0 ){System.out.println("");} // Sauter une ligne toute les deux ligne (smart)
					
		}
		
		
		System.out.println("\n======fin du test=========\n");
	}
	
	/** 
	 * Verifie que le deplacement ne saute pas un pion d'une autre couleur 
	 * OU
	 * que le deplacement ne s'arrete pas sur une case de sa couleur !
	 * Renvoie un tableau avec les 8 déplacements differents 
	 * 1 si le deplacement est possible
	 * 2 si le deplacement chevauche un pion ennemie OU si le deplacement est sur un de mes pions
	 * 3 si le deplacement tue un pion ennemie!
	 * 4 si hors de la map
	 * @param map le tableau 
	 */
	public static int[][] deplacementPion(int[][] pMap, int pLigne, int pColonne, int pColor)
	{
		int[][] ret = new int[8][3];
		int[][] move = new int[8][2];
		int[] dest = new int[8];
		int[] chemin = new int[8];
		if (pColor == 1 || pColor == -1) // Si la couleur est bonne
		{
			// Recupere les deplacement possible avant verification.
			move = brutDeplacementsPion(pMap, pLigne, pColonne);

			//Verifie si la destination est possible.
			dest = verifDestination(pMap, pLigne, pColonne, pColor, move);
			 
			//Verifie si le chemin est possible.
			chemin = verifChemin(pMap, pLigne, pColonne, pColor, move, dest);
		}
		else
		{
			System.out.println("La couleur du joueur n'existe pas !");
		}
		
		
		//Remplissage du tableau de deplacement
		for (int i = 0; i < 8; i++)
		{
			ret[i][0] = move[i][0];
			ret[i][1] = move[i][1];
			ret[i][2] = chemin[i];
		}
		
		return ret;
	}

	/**
	 * Test de DeplacementPion
	 */
	public static void testDeplacementsPion() // ToDo
	{
				System.out.println("\n======Test de VerifChemin =========\n");		

		int tab[][] =  {{0,0,0,0,0,0,0,0,0,0,0},//0
						{1,0,0,0,0,0,0,0,0,0,0},//1
						{0,0,0,0,0,0,0,0,0,0,0},//2
						{0,0,2,0,0,2,0,0,1,0,0},//3
						{0,0,0,0,0,0,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,2,0,0,0,1,2,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,0,1,0,0,0,1,0,0,0},//8
						{0,0,2,0,0,0,0,0,1,0,0},//9
						{0,0,0,0,0,2,0,0,0,1,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10	
		int[][] deplacement = deplacementPion(tab, 6, 5, 1);
		
		System.out.println("");
		for (int i = 0; i < 8; i++)
		{
			System.out.println("dir[" + i + "] = " + deplacement[i][0]  + "\t" + deplacement[i][1] + "\t" + deplacement[i][2] + "\t\n\n");
		}
		
		int tab2[][] = {{1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,-1},//0
						{0 ,0 ,0 ,0 ,-1,0 ,-1,0 ,0 ,0 ,0 },//1
						{0 ,0 ,0 ,1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 },//2
						{0 ,0 ,-1,0 ,0 ,0 ,0 ,0 ,-1,0 ,0 },//3
						{0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 },//4
						{-1,0 ,0 ,0 ,0 ,2 ,0 ,0 ,0 ,0 ,-1},//5
						{0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 },//6
						{0 ,0 ,-1,0 ,0 ,0 ,0 ,0 ,-1,0 ,0 },//7 c 3 l 8
						{0 ,0 ,0 ,1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 },//8
						{0 ,0 ,0 ,0 ,-1,0 ,-1,0 ,0 ,0 ,0 },//9
						{-1,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,1 } //10
					}; //0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10	
		int[][] deplacement2 = deplacementPion(tab2, 0, 5, 1);

		for (int i = 0; i < 8; i++)
		{
			System.out.println("dir[" + i + "] = " + deplacement2[i][0]  + "\t" + deplacement2[i][1] + "\t" + deplacement2[i][2] + "\t");
		}
		
		System.out.println("\n======fin du test=========\n");
	}

	/**
	 * Regarde pour chaque case entre la position du pion et la destination si il y a un pion ennemie
	 * @param pMap le plateau actuelle
	 * @param pLigne la ligne du pion
	 * @param pColonne la colonne du pion
	 * @param pColor la couleur du pion
	 * @param pMove tableau sous forme t[0] = ligne t[1] = colonne contenant la destination du pion
	 * @param pDest tableau avec une indication sur chaque destination pour savoir si il faut traité la direction ou non 
	 * @return tableau de int de 1 a 4
	 * 1 si le deplacement est possible
	 * 2 si le deplacement chevauche un pion ennemie OU si le deplacement est sur un de mes pions
	 * 3 si le deplacement tue un pion ennemie!
	 * 4 si hors de la map
	 */
	public static int[] verifChemin(int[][] pMap, int pLigne, int pColonne, int pColor,int[][] pMove, int[] pDest) // ToDo
	{
		int[] ret = pDest;
		
		//Haut  -- Fait !
		int haut = 0;
		if (ret[haut] != 4 && ret[haut] != 2 ) // Si la destination est possible..
		{
//			System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[haut][0] + "\tpLigneDest " + pMove[haut][1]);
			for (int i = pLigne - 1 ; i > pMove[haut][0] ; i--) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[ i ][ pMove[haut][1] ] != 0 && pMap[ i ][ pMove[haut][1] ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[haut] = 2;
				}
			}
		}	
		
		// Bas -- Fait !
		int bas = 1;
		if (ret[bas] != 4 && ret[bas] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[bas][0] + "\tpLigneDest " + pMove[bas][1]);
			for (int i = pLigne + 1 ; i < pMove[bas][0] ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[i][ pMove[bas][1] ] != 0 && pMap[i][ pMove[bas][1] ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[bas] = 2;
				}
			}
		}			
			
		// Droite -- Fait !
		int droite = 2;
		if (ret[droite] != 4 && ret[droite] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[droite][0] + "\tpLigneDest " + pMove[droite][1]);
			for (int i = pColonne + 1 ; i < pMove[droite][1] ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[ pMove[droite][0] ][ i ] != 0 && pMap[ pMove[droite][0] ][ i ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[droite] = 2;
				}
			}
		}	
			
		// Gauche -- Fait !
		int gauche = 3;
		if (ret[gauche] != 4 && ret[gauche] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[gauche][0] + "\tpColonneDest " + pMove[gauche][1]);
			for (int i = pColonne - 1 ; i > pMove[gauche][1] ; i--) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[ pMove[gauche][0] ][ i ] != 0 && pMap[ pMove[gauche][0] ][ i ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[gauche] = 2;
				}
			}
		}		
			
		// Haut-Gauche -- Fait !
		int hg = 4; 
		if (ret[hg] != 4 && ret[hg] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[hg][0] + "\tpColonneDest " + pMove[hg][1]);
			for (int i = 1 ; i < pLigne - pMove[hg][0] ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if ( pMap[pLigne - i ][pColonne - i] != 0 && pMap[pLigne - i ][pColonne - i] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[hg] = 2;
				}
			}
		}			
		
		// Bas-Droite -- Fait !
		int bd = 5; 
		if (ret[bd] != 4 && ret[bd] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[bd][0] + "\tpColonneDest " + pMove[bd][1]);
			for (int i = 1 ; i < pMove[bd][0] - pLigne  ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[ pLigne + i ][ pColonne + i  ] != 0 && pMap[ pLigne + i ][ pColonne ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[bd] = 2;
				}
			}
		}		
			
			
			
		// Bas-Gauche -- Fait
		int bg = 6; 
		if (ret[bg] != 4 && ret[bg] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[bg][0] + "\tpColonneDest " + pMove[bg][1]);
			for (int i = 1 ; i < pMove[bg][0] - pLigne ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[pLigne + i ][ pColonne - i ] != 0 && pMap[pLigne + i ][ pColonne - i ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[bg] = 2;
				}
			}
		}		
		
		// Haut-Droit
		int hd = 7; 
		if (ret[hd] != 4 && ret[hd] != 2 ) // Si la destination est possible..
		{
//				System.out.println("ligne "+ pLigne + "\tColonne " + pColonne + "\tpLigneDest " + pMove[hd][0] + "\tpColonneDest " + pMove[hd][1]);
			for (int i = 1 ; i < pLigne - pMove[hd][0] ; i++) // Ce for test toute les valeurs entre la position initiale et la destination 
			{
				if (pMap[ pLigne - i ][ pColonne + i ] != 0 && pMap[ pLigne - i ][ pColonne + i ] != pColor ){ // Si la case est ni vide, ni notre pion, alors on chevauche un pion ennemie
					ret[hd] = 2;
				}
			}
		}	
		return ret;
	}
	
	/**
	 *	Test de verifChemin
	 */	
	public static void testVerifChemin() // ToDo
	{
		System.out.println("\n======Test de VerifChemin =========\n");		

		int tab[][] =  {{0,0,0,0,0,0,0,0,0,0,0},//0
						{1,0,0,0,0,0,0,0,0,0,0},//1
						{0,0,0,0,0,0,0,0,0,0,0},//2
						{0,0,2,0,0,2,0,0,1,0,0},//3
						{0,0,0,0,0,0,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0,0},//5
						{0,2,0,0,0,1,2,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,0,1,0,0,0,1,0,0,0},//8
						{0,0,2,0,0,0,0,0,1,0,0},//9
						{0,0,0,0,0,2,0,0,0,1,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10	
		int[][] move = brutDeplacementsPion(tab, 6, 5); // Cette methode dois etre tester avant !
		int[] dest = verifDestination(tab , 6, 5, 1, move );		
		int[] dplacement = verifChemin(tab, 6, 5, 1, move, dest);
		
		System.out.println("");
		for (int i = 0; i < 8; i++)
		{
			System.out.println("dir[" + i + "] = " + dplacement[i] );
		}
		
		System.out.println("\n======fin du test=========\n");
	}	
	
	/**
	 * Verifie si la destination du pion est possible dans chaqu'une des dirrection ( seulement la destination, pas le chemain pour y aller
	 * 1 si le deplacement est possible
	 * 2 si le deplacement chevauche un pion ennemie OU si le deplacement est sur un de mes pions
	 * 3 si le deplacement tue un pion ennemie!
	 * 4 si hors de la map
	 * @param pMap la position actuelle des pions sur le plateau
	 * @param pLigne la ligne actuelle du pion
	 * @param pColonne la colonne actuelle du pion
	 * @param pColor la couleur du pion a bouger
	 * @param pDest les destination "possible" du pion
	 * @return Un tableau de int de 8 elements avec chaque cas pour chaque direction.
	 */
	public static int[] verifDestination(int[][] pMap, int pLigne, int pColonne, int pColor,int[][] pDest)
	{
		int[] ret = new int[8];
			for (int i = 0; i < 8 ; i++) // Pour chaque deplacement possible 
			{
				if ( pDest[i][0] < 11 && pDest[i][0] >= 0 && pDest[i][1] < 11 && pDest[i][1] >= 0 ) // Verifier que la destination de sors pas du plateau 
				{
//					System.out.println(pDest[i][0] + " \t " + pDest[i][1] + " \t " + pMap[ pDest[i][0] ][ pDest[i][1] ] + " \t " + i );
					if ( pMap[ pDest[i][0] ][ pDest[i][1] ] == pColor ) // Si le pion d'arriver est de sa couleur
					{
						ret[i] = 2; // destination impossible
					}
					else if ( pMap[ pDest[i][0] ][ pDest[i][1] ] != pColor && pMap[ pDest[i][0] ][ pDest[i][1] ] != 0 ) // Sinon si le pion d'arriver est different de sa couleur et different de 0 ( donc un pion ennemie )
					{
						ret[i] = 3; // tue un pion ennemie
					}
					else 
					{
						ret[i] = 1; // destination possible
					}
				}
				else
				{
				 ret[i] = 4; // depacement de carte
				}
			}
		return ret;
	}
	
	/**
	 * Test de verifDestination
	 */
	public static void testVerifDestination()
	{
		System.out.println("\n======Test de verifDestination =========\n");		
		
		int tab[][] =  {{0,0,0,0,0,0,0,0,0,0,0},//0
						{0,0,0,0,0,0,0,0,0,0,0},//1
						{0,0,0,0,0,0,0,0,0,0,0},//2
						{0,0,0,0,0,2,0,0,1,0,0},//3
						{0,0,0,2,0,0,0,0,0,0,0},//4
						{0,0,0,0,0,0,1,0,0,0,0},//5
						{0,0,0,2,0,1,0,0,2,0,0},//6
						{0,0,0,0,0,0,0,0,0,0,0},//7 c 3 l 8
						{0,0,0,0,0,0,0,0,0,0,0},//8
						{0,0,0,0,0,2,0,0,0,0,0},//9
						{0,3,0,0,0,0,0,0,0,0,0} //10
					}; //0,1,2,3,4,5,6,7,8,9,10
		int[][] move = brutDeplacementsPion(tab, 6, 5); // Cette methode dois etre tester avant !

		int[] dest = verifDestination(tab , 6, 5, 1, move );
		for (int i = 0; i < 8; i ++ )
		{
			System.out.println("move[" + i + "] = " + dest[i]);
		}
		System.out.println("\n* 1 si le deplacement est possible");	 
		System.out.println("* 2 si le deplacement chevauche un pion ennemie OU si le deplacement est sur un de mes pions");
		System.out.println("* 3 si le deplacement tue un pion ennemie!");
		System.out.println("* 4 si hors de la map\n");

		System.out.println("* tab[0] correspond au déplacement en ligne vers la haut");
	 System.out.println("* tab[1] correspond au déplacement en ligne vers la bas ");
	 System.out.println("* tab[2] correspond au déplacement en colonne vers le droite");
	 System.out.println("* tab[3] correspond au déplacement en colonne vers le gauche");
	 System.out.println("* tab[4] correspond au déplacements en diagonal en haut a gauche");
	 System.out.println("* tab[5] correspond au déplacements en diagonal en bas a droite");
	 System.out.println("* tab[6] correspond au déplacements en diagonal en bas a gauche");
	 System.out.println("* tab[7] correspond au déplacements en diagonal en haut a droite");
	
		System.out.println("\n======fin du test=========\n");
	}	
}



















