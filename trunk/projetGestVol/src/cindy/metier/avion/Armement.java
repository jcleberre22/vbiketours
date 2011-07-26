package cindy.metier.avion;

import cindy.metier.comm.IArmement;

/**
 * La classe armement permet de r�cup�rer l'armement utilis� par un avion.
 * 
 * @author J.Martinez
 * @version 1.0 du 25/07/2011
 * 
 */
public class Armement implements IArmement {

	// attributs
	private String nom;

	// Constructeur
	/**
	 * constructeur de la classe. Celui-ci exige qu'un type d'armement soit
	 * sp�cifi�
	 * 
	 * @param name : nom de l'armement sous forme de String
	 */
	public Armement(String name) {
		setNom(name);
	}

	/**
	 * Constructeur par d�faut. Donne un armement de base lors de sa d�claration
	 * pour un avion
	 */
	public Armement() {
		nom = "S�rie";
	}

	// Accesseur
	/**
	 * Retourne le nom de l'armement.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Fixe un nom pour l'armement. 
	 * Renvoi une exception si le nom est null
	 * @param nom sous forme de String
	 */
	private void setNom(String nom) {
		if (nom == null || nom.trim().length() == 0) {
			throw new RuntimeException("Armement: nom d'armement null");
		}
		this.nom = nom;
	}

}
