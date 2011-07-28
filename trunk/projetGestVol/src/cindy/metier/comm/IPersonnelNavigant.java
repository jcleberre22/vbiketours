package cindy.metier.comm;

import cindy.metier.personnel.Qualification;

/**
 * Interface permettant de r�cuperer des m�thodes de la classe Pilote.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IPersonnelNavigant {

	/**
	 * M�thode qui r�cupere l'identifiant du pilote.
	 * 
	 * @return l'id sous forme d'entier.
	 */
	int getId();

	/**
	 * M�thode qui r�cupere le nom du pilote.
	 * 
	 * @return le nom sous forme de String.
	 */
	String getNom();

	/**
	 * M�thode qui r�cupere le prenom du pilote.
	 * 
	 * @return le pr�nom sous forme de String.
	 */
	String getPrenom();

	/**
	 * M�thode qui r�cupere le grade du pilote.
	 * 
	 * @return le grade sous forme de String.
	 */
	String getGrade();

	/**
	 * M�thode qui r�cupere l'escadron du pilote.
	 * 
	 * @return l'escadron sous forme de String.
	 */
	String getEscadron();

	/**
	 * M�thode qui r�cupere la qualification du pilote.
	 * 
	 * @return la qualification sous forme de String.
	 */
	Qualification getQualification();

	/**
	 * M�thode qui r�cupere le nombre d'heure du vol actif du pilote.
	 * 
	 * @return les heures sous forme d'entier.
	 */
	int getHeureVol();

	/**
	 * M�thode qui permet d'ajouter des heures de vols au pilote. R�gle on ne
	 * peux soustraire des heures de vol.
	 * 
	 * @param nombre
	 *            d'heure � ajouter
	 * @return le nombre d'heure de vol sous forme d'entier.
	 */
	int ajouterNbHeure(int nombre);

}
