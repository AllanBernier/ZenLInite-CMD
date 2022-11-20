public class Utile
{
	public Utile()
	{
		System.out.println("Cette classe contient toutes les methodes pouvant etre utiliser a tout moment que ce soit durant la conception ou des fonction utile pour le jeu");
	}
	
	/**
	 * Affiche le plateau de jeux avec les pions correspondant
	 * en transformant le tableau de int en parametre en ascii
	 * @param pMap le tableau correspondant au plateau
	 */
	public static void afficherPlateau(int[][] pMap)// Plus tard les Lettres seront remplacé par des couleurs
	{

		for (int l = 0; l < 11 ; l++)
		{
			for (int c = 0; c < 11; c ++)
			{
				if( pMap[l][c] == -1) // Couleur 1
				{
					System.out.print("(Blanc)\t");
				}
				else if( pMap[l][c] == 0) // Case vide
				{
					System.out.print("(     )\t");
				}
				else if( pMap[l][c] == 1 ) // Couleur 2
				{
					System.out.print("(Noir )\t");
				}
				else if (pMap[l][c] == 2) // Zen l'initié
				{
					System.out.print("(Zen)\t");
				}	
			}
			System.out.println( (11-l) + "\t\n" );
		}
		System.out.println("   A       B       C       D       E       F       G       H       I      J      K    ");
		System.out.println("________________________________________________________________________________________");

	}
	
	/**
	 * Test de la methode afficherPlateau
	 * 
	 */	
	public static void testAfficherPlateau()
	{
		System.out.println("\n======Test de afficherPlateau=========\n");
		System.out.println("Test purement graphique,\nVerifier juste que le tableau ne soit pas inverser par rapport a la diagonal haut-gauche\n( erreur frequente)\n");
		int tab[][] =  {{1 ,0 ,0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0},//0
						{0 ,0 ,1 ,0 ,0 ,0 ,0 ,1 ,0 ,1 ,0},//1
						{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,-1,0 ,0},//2
						{1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0},//3
						{0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0 ,0 ,0},//4
						{0 ,0 ,0 ,0 ,0 ,2 ,0 ,0 ,0 ,0 ,0},//5
						{0 ,0 ,0 ,1 ,0 ,-1,0 ,1 ,0 ,0 ,0},//6
						{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},//7 
						{0 ,0 ,-1,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0},//8
						{0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0},//9
						{0 ,0 ,0 ,0 ,-1,0 ,0 ,0 ,0 ,0 ,0} //10
					}; //0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10				
		
		afficherPlateau(tab);

		System.out.println("\n======fin du test=========\n");
	}
	
	/**
	 * Affiche un tableau de int a deux dimension
	 * @param pTab le tableau de int. 
	 */
	public static void afficherTab(int[][] pTab)
	{
		for (int l = 0; l < 11; l++)
		{
			for (int c = 0; c < 11; c++)
			{	
				System.out.print(pTab[l][c] + "\t");
			}		
			System.out.println();
		}		
	}
	
	/**
	 * Test de la methode afficherTab
	 */
	 
	public static void TestafficherTab()
	{
		System.out.println("\n======Test de afficherTab=========\n");
		System.out.println("Test purement graphique,\nVerifier juste que le tableau ne soit pas inverser par rapport a la diagonal haut-gauche\n( erreur frequente)\n");
		int tab[][] =  {{1 ,0 ,0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0},//0
						{0 ,0 ,1 ,0 ,0 ,0 ,0 ,1 ,0 ,1 ,0},//1
						{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,-1,0 ,0},//2
						{1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0},//3
						{0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0 ,0 ,0},//4
						{0 ,0 ,0 ,0 ,0 ,2 ,0 ,0 ,0 ,0 ,0},//5
						{0 ,0 ,0 ,1 ,0 ,-1,0 ,1 ,0 ,0 ,0},//6
						{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},//7 
						{0 ,0 ,-1,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0},//8
						{0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0},//9
						{0 ,0 ,0 ,0 ,-1,0 ,0 ,0 ,0 ,0 ,0} //10
					}; //0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10				
		
		afficherTab(tab);

		System.out.println("\n======fin du test=========\n");
	}	
	
	
	/**
	 * Simplification de System.out.println en println en print
	 */
	public static void print( String s)
	{
		System.out.println(s);
	}
	
	
	
	
	/**
	 * Affiche le plateau de jeux avec les pions correspondant et les deplacements possible pour le pion demander
	 * en transformant le tableau de int en parametre en ascii
	 * @param pMap le tableau correspondant au plateau
	 */
	public static void afficherDeplacements(int[][] pMap,int[][] pDeplacements,int[] posPion)// Plus tard les Lettres seront remplacé par des couleurs
	{
		String[][] myTab = new String[11][11];
	System.out.println("BurnOut");
		for (int l = 0; l < 11 ; l++)
		{
			for (int c = 0; c < 11; c ++)
			{				
				if( pMap[l][c] == -1) // Couleur 1
				{
					myTab[l][c] = "(Blanc)\t";
				}
				else if( pMap[l][c] == 0) // Case vide
				{
					myTab[l][c] = "(     )\t";
				}
				else if( pMap[l][c] == 1 ) // Couleur 2
				{
					myTab[l][c] = "(Noir )\t";
				}
				else if (pMap[l][c] == 2) // Zen l'initié
				{
					myTab[l][c] = "(Zen  )\t";
				}
				
			}
		}
		
		myTab[ posPion[0] ][ posPion[1] ] = "[" + myTab[ posPion[0] ][ posPion[1] ].substring(1,6) + "]\t";

		
		for (int i = 0; i < 8 ; i++)
		{
			if (pDeplacements[i][2] == 1)
			{
				myTab[ pDeplacements[i][0] ][ pDeplacements[i][1] ] = "[[" + myTab[ pDeplacements[i][0] ][ pDeplacements[i][1] ].substring(2,5) + "]]\t";
			}
			else if( pDeplacements[i][2] == 3 )
			{
				myTab[ pDeplacements[i][0] ][ pDeplacements[i][1] ] = "{{" + myTab[ pDeplacements[i][0] ][ pDeplacements[i][1] ].substring(2,5) + "}}\t";
			}
		}
		
		for (int l = 0; l < 11 ; l++)
		{
			for (int c = 0; c < 11; c ++)
			{	
				System.out.print(myTab[l][c] );
			}
			System.out.println( (11-l) + "\t\n" );
		}
		System.out.println("   A       B       C       D       E       F       G       H       I      J      K    ");
		System.out.println("________________________________________________________________________________________");

	}
	
	public static void testAfficherDeplacements()
	{
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
		int[] posPion = {0,5};
		int[][] deplacement2 = deplacements.deplacementPion(tab2, 0, 5, 1);
		afficherDeplacements(tab2 , deplacement2,posPion);
		
		for (int i = 0; i < 8; i++)
		{
			System.out.println("dir[" + i + "] = " + deplacement2[i][0]  + "\t" + deplacement2[i][1] + "\t" + deplacement2[i][2] + "\t");
		}
		
		
	}	
}
