package cindy.metier.vol;

import cindy.metier.comm.ICategorie;

/**
 * Classe categorie. 
 * Elle va référencer une catégorie de vol.
 * @author J.Martinez 
 * @version 1.0 du 26/07/2011
 */
public class Categorie implements ICategorie {

	// attributs
	private int numCategorie;
	private String nom;

	// constructeur
	/**
	 * constructeur de la classe. Obligation d'avoir une categorie
	 * @param numero sous forme d'entier(1 à 5)
	 * @param nom sous forme de String
	 */
	public Categorie(int numCategorie, String nom) {
		setNumCategorie(numCategorie);
		setCategorie(nom);
	}

	// accesseurs

	/**
	 * Setter qui donne la catégorie. Renvoi une exception si la chaîne donnée
	 * est nulle
	 * @param categorie sous forme d'un String
	 */
	private void setCategorie(String categorie) {
		if (categorie == null || categorie.trim().length() == 0){
			throw new RuntimeException("Categorie : une valeur null a été inséré dans la catégorie");
		}
		this.nom = categorie;	
		
	}

	/**
	 * Retourne le numero de la categorie.
	 * @return numCategorie sous forme d'un entier
	 */
	public int getNumCategorie() {
		return numCategorie;
	}

	/**
	 * @return nom de la categorie
	 */
	public String getNomCategorie() {
		return nom;
	}

	/**
	 * Fixe le numero de la categorie
	 * @param numCategorie sous forme d'un entier
	 */
	public void setNumCategorie(int numCategorie) {
		if (numCategorie <= 0 ){
			throw new RuntimeException("Categorie : le numero ne peut pas être négatif ou egal à 0");
		}
		this.numCategorie = numCategorie;
	}

	/**
	 * Donne le nom de la categorie.
	 * @param nom sous forme de String
	 */
	public void setNomCategorie(String nom) {
		if (nom == null)
			throw new RuntimeException(
					"Categorie : il faut renseigner la catégorie");
		this.nom = nom;
	}

}
