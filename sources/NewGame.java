public class NewGame
{
	private int[][] plateau = new int [11][11];
	private boolean whoStart;
	
	
	public NewGame()
	{
		
		this.plateau = initPlateau();			
		this.whoStart = choiceWhoStart();
		// Choix du joueur qui commence
		
	}
	
	/** 
	 * Renvoit un boolean avec 50% de chance d'etre initialiser à true et 50% à flase pour savoir qui commence  
	 * True : joueur 1 commence
	 * False: joueur 2 commence
	 * @return le joueur qui commence
	 */
	public static boolean choiceWhoStart()
	{
		return Math.random() < 0.5; // à verifier !
	}
	
	/**
	 * Test de la methode choiceWhoStart
	 */
	public static void testChoiceWhoStart()
	{
		System.out.println("\n======Test de choiceWhoStart=========\n");
			System.out.println("Affiche 10 fois le resultat de la fonction");
			for (int i = 0; i < 10; i++)
			{
				System.out.print( choiceWhoStart() + "\t");
			}
			System.out.println();
		System.out.println("\n======fin du test=========\n");
	}

	/**
	 * Configure le tableau du debut de partie.
	 * @return tableau de int a deux dimensions.
	 */

	public static int[][] initPlateau()
	{
		int tab[][] =  {{1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,-1},//0
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
		return tab;
	}
	
	/**
	 * Test de la methode choiceWhoStart
	 */
	
	public static void testInitPlateau()
	{
		System.out.println("\n======Test de testInitPlateau=========\n");
			int tab[][] = initPlateau();
			System.out.println("Affichage du tableau renvoyer");
			Utile.afficherTab(tab);
		System.out.println("\n======fin du test=========\n");
	}
	
	
}
