package cindy.paqMetier.vol;

import cindy.paqMetier.comm.ICategorie;

/**
 * 
 * @author J.Martinez 
 * classe categorie.
 * va référencer une catégorie de vol
 */
public class Categorie implements ICategorie {

	// attributs
	int numCategorie;
	String description;
	String[] nom = {"Mission logistique","Vol d'entraînement","Vol d'entraînement tactique",
				"Vol de contrôle ou d'expérimentation","Mission tactique réelles, de transport ou de combar"};

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
	 * Setter qui donne la catégorie. Renvoi une exception si la chaîne donnée
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
				"Categorie : une valeur non permise a été inséré dans la catégorie");
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
					"Categorie : le numero doit être compris entre 1 et 5");
		this.numCategorie = numCategorie;
	}


}
