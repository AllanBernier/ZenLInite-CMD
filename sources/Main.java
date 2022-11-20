/**
 * Projet de programmaiton 2020
 * Jeux de Zen L'initié
 * @author Bernier Allan 
 */
import java.util.Scanner;
 
public class Main
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int imput;

		do
		{
		System.out.println("Veuillez entrer 1 pour jouer ou 2 pour voir les tests :");
			imput = sc.nextInt();
		}
		while (imput != 1 && imput != 2 );
		
		if (imput == 1 ){
			Terminal.game();
		}
		else if (imput == 2) 
		{
			test();
		}
		
	}

	public static void test()
	{
		//Ces test sont realiser dans leur ordre de creation.
		deplacements.testNbInLigne();
		deplacements.testNbInColonne();
		deplacements.testNbInDiagonalGauche();
		deplacements.testNbInDiagonalDroite();
		deplacements.testBrutDeplacementsPion();
		NewGame.testChoiceWhoStart();
		NewGame.testInitPlateau();
		Utile.testAfficherPlateau();
		Utile.TestafficherTab();
		deplacements.testDeplacementsPion();
		deplacements.testVerifDestination();
		deplacements.testVerifChemin();
		Utile.testAfficherDeplacements();
		Terminal.testAskPion();
		Terminal.testDechiffre();
	}
	
	
	
	
	
	
	
	
	
	
}
