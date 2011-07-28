package cindy.paqMetier.vol;

import cindy.paqMetier.comm.ICategorie;

/**
 * 
 * @author J.Martinez 
 * classe categorie.
 * va r�f�rencer une cat�gorie de vol
 */
public class Categorie implements ICategorie {

	// attributs
	int numCategorie;
	String description;
	String[] nom = {"Mission logistique","Vol d'entra�nement","Vol d'entra�nement tactique",
				"Vol de contr�le ou d'exp�rimentation","Mission tactique r�elles, de transport ou de combar"};

	// constructeur
	/**
	 * constructeur de la classe. Obligation d'avoir une categorie
	 */
	public Categorie(int numero) {
		setNumCategorie(numero);
		setCategorie(numero);
	}

	// accesseurs

	/**
	 * Setter qui donne la cat�gorie. Renvoi une exception si la cha�ne donn�e
	 * est nulle
	 */
	private void setCategorie(int numCategorie) {
		if (numCategorie > 0 || numCategorie <= 5){
			switch (numCategorie) {
			case 1:
				this.description = nom[numCategorie-1]; 
				break;
			case 2:
				this.description = nom[numCategorie-1];
				break;
			case 3:
				this.description = nom[numCategorie-1];
				break;
			case 4 :
				this.description = nom[numCategorie-1];
				break;
			case 5 :
				this.description = nom[numCategorie-1];
			}
		}
		throw new RuntimeException(
				"Categorie : une valeur non permise a �t� ins�r� dans la cat�gorie");
	}

	/**
	 * @return numero de la categorie
	 */
	public int getNumCategorie() {
		return numCategorie;
	}

	/**
	 * @return nom de la categorie
	 */
	public String getNomCategorie() {
		return description;
	}

	/**
	 * fixe le numero de la categorie
	 * 
	 * @param numCategorie
	 */
	public void setNumCategorie(int numCategorie) {
		if (numCategorie <= 0)
			throw new RuntimeException(
					"Categorie : le numero doit �tre compris entre 1 et 5");
		this.numCategorie = numCategorie;
	}


}
