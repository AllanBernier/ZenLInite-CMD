import java.util.Scanner;


public class Terminal
{
	/**
	 * Demande une position au joueur sous la forme "colonneLigne" dans un string puis le transforme en deux int distinct 
	 * Ne s'arrete de demander que lorceque la reponce est acceptable !
	 * @param pColor, savoir a qui l'on demande voyons !
	 * @param pTableau savoir si le joueur joue bien un pion de sa couleur
	 * @return int[] tableau contenant la position sous forme {ligne,colonne}
	 */
	public static int[] askPion(int pColor, int[][] pPlateau)
	{
		Scanner sc = new Scanner(System.in);
		int[] pos;
		boolean wend = false;
		do
		{
			Utile.afficherPlateau(pPlateau);
			if (pColor == -1)
			{
				System.out.println("===================== Joueur Blanc, a toi de jouer ======================");
			}
			else
			{
				System.out.println("===================== Joueur Noir , a toi de jouer ======================");
			}
			System.out.print("entrez une position : ");
			
			String str = sc.nextLine();
			pos = dechiffre(str);
			
			
			if (pos[0] != -1 && pos[1] != -1)
			{
				if (pPlateau[pos[0] ][ pos[1] ] == pColor)
				{
					wend = !wend;
				}
			}
		}
		while (!wend);

		return pos;
	}
		
	/**
	 * Test de askPion
	 */
	 public static void testAskPion()
	 {
		System.out.println("\n======Test de askPion =========\n");		
			 int[][] tab = NewGame.initPlateau();
			 Utile.afficherPlateau(tab);
			 int[] pos = askPion(-1,tab);
			 System.out.println("\t pos[0] = "+ pos[0] + "pos[1] = "+ pos[1] );
		System.out.println("\n======fin du test=========\n");
	 }
	
	
	/**
	 * Recupere un string et le renvoie sous forme d'un tableau de int a deux valeurs comprises entre 0 et 10
	 * Si le string ne correspond pas pour etre transformer alors le tableau renvoyer est {-1,-1}.
	 * @param pPos un string normalement sous forme "A5" pour A = colonne et 5 = ligne
	 * @return les ligne colonne de l'endrois voulue.
	 */
	public static int[] dechiffre( String pPos)
	{
		pPos =  pPos.toLowerCase(); // Supprimer les majuscules
		char[] cColonne = {'a','b','c','d','e','f','g','h','i','j','k'};
		char col = pPos.charAt(0);
		
		int colonne = -1; // Si la colonne n'est pas dans le tableau de colonne return -1
		int ligne = - 1;
		for(int i = 0; i < cColonne.length; i++)
		{
			if ( col == cColonne[i] ) // Sinon elle correspond à une vraie colonne ! 
			{
				colonne = i;
			}
		}

		try
		{
			ligne = Integer.parseInt( pPos.substring(1) ) - 1;  // -1 car les tableaux commencent à 0 
			ligne = 10 - ligne; // 10 - ligne car les lignes sont compté à l'envers sur un echiquier
			if ( !(ligne >= 0 && ligne < 11) )
			{
				ligne = -1;
			}
		}
			catch (NumberFormatException e) 
		{
			int[] ret = {-1,-1};
			System.out.println("Un vrais nombre, tu vas me faire crash !");
			return ret;
		}

		int[] ret = {ligne,colonne}; 
	//	System.out.println(ret[0] + " \t" + ret[1] + "\tCoucou");
		return ret;
	}
	
	
	/**
	 * Test de Dechiffre
	 */
	public static void testDechiffre()
	{
		System.out.println("\n======Test de Dechiffre =========\n");		
			int[] tab;
			System.out.println("\nEnvoit de la chaine \" \" ");
			tab = dechiffre(" ");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"dzafaz \" ");
			tab = dechiffre("dzafaz");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
		
			System.out.println("\nEnvoit de la chaine \"G4 \" ");
			tab = dechiffre("G4");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"A0\" ");
			tab = dechiffre("A0");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
		
			System.out.println("\nEnvoit de la chaine \"B1\" ");
			tab = dechiffre("B1");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"C2\" ");
			tab = dechiffre("C2");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"d3\" ");
			tab = dechiffre("d3");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
		
			System.out.println("\nEnvoit de la chaine \"K2\" ");
			tab = dechiffre("K2");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"J7\" ");
			tab = dechiffre("J7");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"H1\" ");
			tab = dechiffre("H1");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
			
			System.out.println("\nEnvoit de la chaine \"B1\" ");
			tab = dechiffre("B1");
			System.out.println("\t tab[0] = "+ tab[0] + "tab[1] = "+ tab[1] );
		
		
		System.out.println("\n======fin du test=========\n");
	}
	
	
	
	public static void game()
	{
		Scanner sc = new Scanner(System.in);
		NewGame game = new NewGame();
		//int[][] plateau = game.getPlateau();
		int[][] plateau = NewGame.initPlateau();
		
		
		System.out.println("Choisissez entre vous qui est le joueur true et qui est le joueur false !");
		System.out.println("Press [Entrez]");
		sc.nextLine();
		boolean starter = NewGame.choiceWhoStart();
		System.out.println("Le joueur " + starter + " Commence !");
		System.out.println("choisis ta couleur");
		int imputInt;
		
		do
		{
		System.out.println("[1] Blanc \t [2] Noir ");
			imputInt = sc.nextInt();
		}
		while (imputInt != 1 && imputInt != 2 );
		System.out.println("Entrez vos deplacement sous forme \"A10\", \"B5\"...");
		System.out.println("Press [Entrez]");
		sc.nextLine();
		
		int player = 1;	  // Noir

		if (imputInt == 1){	player = -1; } // Blanc
		
		
		while(true)
		{			
			if (player == 1 )
			{
				player = -1 ;
				newTurn(1, plateau)	;
			}	
			else
			{
				player = 1;
				newTurn(-1, plateau);	
			}
			
		
		}
		
	}
	
	public static void newTurn(int pPlayer,int[][] pPlateau)
	{
		int[] pos = askPion(pPlayer, pPlateau);
		int[][] move = deplacements.deplacementPion(pPlateau,pos[0],pos[1],pPlayer);
		Utile.afficherDeplacements(pPlateau,move,pos);
		move(pPlayer, pPlateau, move,pos);
	}
	
	
	
	/**
	 * Demande une position au joueur sous la forme "colonneLigne" dans un string puis le transforme en deux int distinct 
	 * Ne s'arrete de demander que lorceque la reponce est acceptable !
	 * Cette methode s'utilise lorcequ'un pion est deja selectionner !
	 * @param pColor, savoir a qui l'on demande voyons !
	 * @param pTableau savoir si le joueur joue bien un pion de sa couleur
	 * @return int[] tableau contenant la position sous forme {ligne,colonne}
	 */
	public static void move(int pColor, int[][] pPlateau,int[][] pDeplacements,int[] pPos)
	{
		Scanner sc = new Scanner(System.in);
		if (pColor == -1)
		{
			System.out.println("Joueur Blanc, a toi de jouer ");
		}
		else
		{
			System.out.println("Joueur Noir, a toi de jouer ");
		}
			
		int[] pos;
		boolean wend = false;
		do
		{
			Utile.afficherDeplacements(pPlateau,pDeplacements,pPos);
			if (pColor == -1)
			{
				System.out.println("===================== Joueur Blanc, a toi de jouer ======================");
			}
			else
			{
				System.out.println("===================== Joueur Noir , a toi de jouer ======================");
			}
			System.out.print("entrez une position : ");
			
			String str = sc.nextLine();
			pos = dechiffre(str);
			
		
			
			if (pos[0] != -1 && pos[1] != -1)
			{
				
				for(int i = 1; i < 8; i++){
					if (pos[0] == pDeplacements[i][0]  ) //( pDeplacements[i][3] == 3 || pDeplacements[i][3] == 1) J'etais fatigué
					{
						if ( pos[1] == pDeplacements[i][1] )
						{
							pPlateau[ pos[0] ][ pos[1] ] = 0 ;
							pPlateau[ pDeplacements[i][0] ][ pDeplacements[i][1] ] = pColor;
							wend = !wend;
						}
					}
				}
			}
		}
		while (!wend);
	}
	
	
}
