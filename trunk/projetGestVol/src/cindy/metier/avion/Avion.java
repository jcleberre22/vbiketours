package cindy.metier.avion;

import cindy.metier.comm.IAvion;

/**
 * class avion . Va nous donner l'immatriculation, le nom et le type d'avion
 * dans laquelle on pourra lui d�finir un armement
 * 
 * @author J.Martinez
 * @version 1.0 du 27/07/2011
 */
public class Avion implements IAvion {
	// TODO : v�rifier que le nom est possible en fonction du type de l'avion

	// Attributs
	private String immatriculation;
	private String nom;
	private String type;
	private boolean disponibilite;

	/**
	 * constructeur de la classe . instancie un avion, on considerera qu'un
	 * avion doit poss�der au moins une immatriculation et un type
	 * 
	 * @param immat
	 * @param name
	 * @param leType
	 * @param heure
	 */
	// constructeur
	public Avion(String immat, String name, String leType, boolean disponible) {
		setImmatriculation(immat);
		setNom(name);
		setType(leType);
		setDisponibilite(disponible);
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
	 * @return la disponibilit� de l'avion
	 */
	public boolean isDisponibilite() {
		return disponibilite;
	}

	/**
	 * indique si un avion est disponible ou non
	 * 
	 * @param disponibilite
	 */
	private void setDisponibilite(boolean disponibilite) {
		if (disponibilite)
			this.disponibilite = disponibilite;
		else
			throw new RuntimeException(
					"L'avion n'est pas disponible et ne peut donc servir � la mission");
	}

	/**
	 * Donne une immatriculation � l'avion. Une exception est lanc�e si
	 * l'immatriculation saisie est nulle
	 * 
	 * @param immatriculation
	 */
	private void setImmatriculation(String immatriculation) {
		if (immatriculation == null || immatriculation.trim().length() == 0)
			throw new RuntimeException(
					"Avion : l'immatriculation ne peut �tre nulle");
		this.immatriculation = immatriculation;

	}

	/**
	 * Fixe le nom de l'avion. Exception si le nom saisi est null
	 * 
	 * @param nom
	 */
	private void setNom(String nom) {
		if (nom.equals(null) || nom.trim().length() == 0) {
			throw new RuntimeException("Avion : nom null");
		} else
			this.nom = nom;
	}

	/**
	 * Fourni le type de l'appareil. Exception si la cha�ne est nulle
	 * 
	 * @param type
	 */
	private void setType(String type) {
		if (type == null || type.trim().length() == 0)
			throw new RuntimeException("Avion : type null");
		this.type = type;
	}

}
