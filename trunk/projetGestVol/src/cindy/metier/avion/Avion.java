package cindy.metier.avion;

import cindy.metier.comm.IAvion;

/**
 * 
 * class avion. Va nous donner l'immatriculation, le nom et le type d'avion dans
 * laquelle on pourra lui définir un armement
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class Avion implements IAvion {
	// TODO : vérifier que le nom est possible en fonction du type de l'avion

	// Attributs
	private String immatriculation;
	private String nom;
	private String type;

	/**
	 * constructeur de la classe . instancie un avion, on considerera qu'un
	 * avion doit posséder au moins une immatriculation et un type
	 * 
	 * @param immat
	 *            sous forme de String
	 * @param name
	 *            sous forme de String
	 * @param leType
	 *            sous forme de String
	 */
	// constructeur
	public Avion(String immat, String name, String leType) {
		setImmatriculation(immat);
		setNom(name);
		setType(leType);
	}

	/**
	 * Constructeur. Accepte que le nom d'avion ne soit pas renseigné
	 * 
	 * @param immat
	 * @param leType
	 */
	public Avion(String immat, String leType) {
		setImmatriculation(immat);
		setType(leType);
	}

	// accesseurs
	/**
	 * retourne le nom de l'avion.
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * retourne le type de l'avion.
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * retourne l'immatriculation de l'avion.
	 * 
	 * @return
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Donne une immatriculation à l'avion. Une exception est lancée si
	 * l'immatriculation saisie est nulle
	 * 
	 * @param immatriculation
	 */
	private void setImmatriculation(String immatriculation) {
		if (immatriculation == null || immatriculation.trim().length() == 0){
			throw new RuntimeException("Avion : l'immatriculation ne peut être nulle");
		}
		this.immatriculation = immatriculation;

	}

	/**
	 * Fixe le nom de l'avion. Exception si le nom saisi est null
	 * 
	 * @param nom
	 *            sous forme de String
	 */
	private void setNom(String nom) {
		if (nom == null || nom.trim().length() == 0) {
			throw new RuntimeException("Avion : nom null");
		}
		this.nom = nom;

	}

	/**
	 * Fourni le type de l'appareil. Exception si la chaîne est nulle
	 * 
	 * @param type
	 *            sous forme de String
	 */
	private void setType(String type) {
		if (type == null || type.trim().length() == 0) {
			throw new RuntimeException("Avion : type null");
		}
		this.type = type;
	}

	// methodes

}
