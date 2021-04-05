package fr.eql.ai109.algo;

import java.util.Random;
import java.util.Scanner;

	public class PierreFeuilleCiseau {

		// Définir les paramètres en entrée
		// 2 joueurs : humain et ordi
		static int scoreJoueur = 0; // score du joueur
		static int scoreOrdi = 0;   // score de l'ordi
			
		static String choixOrdi;
		static String choixJoueur;
		
		static final String MESSAGE_ORDI_GAGNE = "L'ordinateur a gagné !!";
		static final String MESSAGE_JOUEUR_GAGNE = "Vous avez gagné !!";

		
		
		static void determinerChoixJoueur()	{
			// 1.1 demander au joueur de choisir : afficher "votre choix (pierre/feuille/ciseau) ? "
			System.out.println("Votre choix ? ");
			
			// 1.2 récupérer le choix du joueur (pierre/feuille/ciseau)
			Scanner scan = new Scanner(System.in);
			choixJoueur = scan.next();
			
			// 1.3 vérifer que le choix est valide
			// TODO implémenter verification choix joueur
		}
		
		static void determinerChoixOrdi() {
			// 2.1 générer une valeur aléatoire comprise entre 0 et 2 (inclus)
			
			int indexChoixOrdi;
			Random generateur = new Random(); // objet random : generateur de valeurs aléatoires				
			indexChoixOrdi = generateur.nextInt(3); // entier compris entre 0 et 2

			// 2.2 transformer cette valeur en choix (pierre = 0 / feuille = 1 / ciseau = 2)

			// tableauChoix : [pierre|feuille|ciseau] >> tableau de string de taille 3
			String[] tableauChoix = {"pierre","feuille","ciseau"};
			choixOrdi = tableauChoix[indexChoixOrdi];
			
			// 2.3 afficher le choix de l'ordi
			
			System.out.println("Choix ordi : " + choixOrdi);
		}
		
		static void calculerResultat()
		{
			// 3.1 comparer les choix et mettre à jour le score

			if(choixJoueur.equals(choixOrdi)) {
				System.out.println("égalité !");
			}
			else {
				switch(choixJoueur)	{
					case "pierre" :
						if (choixOrdi.equals("feuille")) {
							enregistrerVictoireOrdi();
						}
						else
						{
							enregistrerVictoireJoueur();
						}
					break;
					case "feuille" :
						if (choixOrdi.equals("ciseau")) {
							enregistrerVictoireOrdi();
						}
						else
						{
							enregistrerVictoireJoueur();
						}
					break;
					case "ciseau" :
						if (choixOrdi.equals("pierre")) {
							enregistrerVictoireOrdi();
						}
						else
						{
							enregistrerVictoireJoueur();
						}
					break;
				}
			}
		}
		
		public static void main(String[] args) {
			
			// jouer une partie
			
			determinerChoixJoueur();
					
			determinerChoixOrdi();
					
			calculerResultat();
					
			// 4 afficher le score
			System.out.println("Joueur : " + scoreJoueur + " - Ordi : " + scoreOrdi);
			
			// TODO répéter plusieurs parties
			
		}

		private static void enregistrerVictoireJoueur() {
			System.out.println(MESSAGE_JOUEUR_GAGNE);
			scoreJoueur ++;
		}
		
		public static void enregistrerVictoireOrdi() {
			System.out.println(MESSAGE_ORDI_GAGNE); 
			scoreOrdi ++;
		}
		

	}

		

