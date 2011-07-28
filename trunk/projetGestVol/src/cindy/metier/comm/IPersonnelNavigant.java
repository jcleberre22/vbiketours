package cindy.metier.comm;

import cindy.metier.personnel.Qualification;

/**
 * Interface permettant de récuperer des méthodes de la classe Pilote.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IPersonnelNavigant {

	/**
	 * Méthode qui récupere l'identifiant du pilote.
	 * 
	 * @return l'id sous forme d'entier.
	 */
	int getId();

	/**
	 * Méthode qui récupere le nom du pilote.
	 * 
	 * @return le nom sous forme de String.
	 */
	String getNom();

	/**
	 * Méthode qui récupere le prenom du pilote.
	 * 
	 * @return le prénom sous forme de String.
	 */
	String getPrenom();

	/**
	 * Méthode qui récupere le grade du pilote.
	 * 
	 * @return le grade sous forme de String.
	 */
	String getGrade();

	/**
	 * Méthode qui récupere l'escadron du pilote.
	 * 
	 * @return l'escadron sous forme de String.
	 */
	String getEscadron();

	/**
	 * Méthode qui récupere la qualification du pilote.
	 * 
	 * @return la qualification sous forme de String.
	 */
	Qualification getQualification();

	/**
	 * Méthode qui récupere le nombre d'heure du vol actif du pilote.
	 * 
	 * @return les heures sous forme d'entier.
	 */
	int getHeureVol();

	/**
	 * Méthode qui permet d'ajouter des heures de vols au pilote. Règle on ne
	 * peux soustraire des heures de vol.
	 * 
	 * @param nombre
	 *            d'heure à ajouter
	 * @return le nombre d'heure de vol sous forme d'entier.
	 */
	int ajouterNbHeure(int nombre);

}
