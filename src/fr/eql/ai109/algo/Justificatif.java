package fr.eql.ai109.algo;

import java.util.ArrayList;
import java.util.Scanner;
public class Justificatif {
	public static void main(String[] args) {
		int nbreLettre = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer une phrase non justifier"); 
		String phraseUtilisateur = scan.nextLine();

		// transforme une String en un tableau de caractères :
		PhraseJustification phraseJustification = new PhraseJustification();
		
		char [] phrase = phraseJustification.transformeToCharArray(phraseUtilisateur);
		
		// 2 - determiner le nombre de lettres (tout sauf espaces)
		nbreLettre= phraseJustification.calculeNbreLettre(phrase); 
	      
		// 3 - déterminer le nombre de mots
		int nbreMots = 0; 
		nbreMots = phraseJustification.calculeNbreMots(phrase); 
		
		// 4 - déterminer le nombre de séparateurs >> nbMots - 1
		int nbreSeparateurs = phraseJustification.calculeNbreSeparateur(nbreMots);  


		// 5 - déterminer le nombre d'espaces de la ligne >> 80 - nombre de lettres
		int nbreEspace = phraseJustification.calculeNbreEspace(nbreLettre); 

		// 6 - déterminer la taille du séparateur >>  nbEspaces / nbSeparateurs
		int tailleSeparateur = phraseJustification.calculeTailleSeparateur(nbreEspace, nbreSeparateurs); 

		//Calcul reliquat
		int reliquat = nbreEspace % nbreSeparateurs; 

		// Créer une ligne de 80+MG5+MD5
		char[] ligne = new char[90]; 
		
		//Marge Gauche
		for (int i= 0; i <5; i++)
			ligne[i]='*';
		//Marge Droite
		for (int i= ligne.length - 1; i > ligne.length -  6; i--)
			ligne[i] = '*';	


		// 			répéter
		//          	afficher 1 mot
		//				si pas le dernier mot alors afficher 1 séparateur :
		// 					si n espaces restants (reliquat) >> ajouter 1 espace aux n premiers séparateurs 	
		// 					-----mot1*******$mot2*******$mot3*******mot4*******mot5-----
		//			tant que mots à afficher

		//    7.3 - afficher la marge droite
		phraseJustification.justificationPhrase(phrase, ligne, tailleSeparateur, reliquat);
		
		



	}


}