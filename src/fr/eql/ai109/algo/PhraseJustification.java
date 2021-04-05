package fr.eql.ai109.algo;

public class PhraseJustification {
	
	
	public char[] transformeToCharArray(String phraseUtilisateur) {
	char[] phrase = phraseUtilisateur.toCharArray();
	for (int i =0; i<phrase.length; i++)
		System.out.print(phrase[i]);
	return phrase;
	
	}
	public int calculeNbreLettre(char[]phrase) {
		int nbreLettre=0; 
		for (char c : phrase) {
			if(c != ' ')    
				nbreLettre++;  
		}
		return nbreLettre; 
		
	}
	public int calculeNbreMots(char[]phrase) {
		int nbreMots = 0; 

		for (int i = 0; i < phrase.length; i++) {
			if (phrase[i] == ' ' && i > 0 && phrase[i-1]!=' ') 
				nbreMots++;	

			if ( i == phrase.length - 1 && phrase[i]!= ' ')
				nbreMots++;
		}
		System.out.println(nbreMots);
		return nbreMots; 
	}
	public int calculeNbreSeparateur(int nbreMots) {
		return nbreMots - 1;
		
	}
	public int calculeNbreEspace(int nbreLettre) {
		return 80 - nbreLettre;
		
	}
	public int calculeTailleSeparateur(int nbreEspace, int nbreSeparateurs) {
		return nbreEspace/nbreSeparateurs;
		
	}
	public void justificationPhrase(char[]phrase, char[]ligne, int tailleSeparateur, int reliquat) {
		boolean hasLetter = false; 
		int j=5; 
		for (int i=0; i<phrase.length; i++)
		{			
			if (hasLetter == true) {
				if (phrase[i] != ' ') {
					ligne[j] = phrase[i]; 
					j++;
				} 
				else {
					if (phrase[i] ==' ' && i < phrase.length - 1 && phrase[i+1] != ' ') {
						for (int k=0; k< tailleSeparateur; k++) {
							ligne[j] =' ';  
							j++;							
						}
						if (reliquat >0) {
							ligne[j] = ' ';
							reliquat = reliquat - 1; 
							j++; 
						}
					}
				}
			}
			else
			{
				if (phrase[i] != ' '){
					ligne[j] = phrase[i]; 
					j++;
					hasLetter=true;
				}
			}
		}

		for (int i =0; i<ligne.length; i++)
			System.out.print(ligne[i]);





	}
}

	
	
	

