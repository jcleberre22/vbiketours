package cindy.metier.comm;

/**
 * Interface permettant de récuperer des méthodes de la classe Avion.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IAvion {

	/**
	 * Méthode qui retourne le nom de l'avion.
	 * 
	 * @return le nom de l'avion
	 */
	String getNom();

	/**
	 * Méthode qui retourne le type de l'avion
	 * 
	 * @return le type d'avion sous forme de String
	 */
	String getType();

	/**
	 * Méthode qui retourne l'immatriculation
	 * 
	 * @return l'immatriculation de l'avion sous forme de String
	 */
	String getImmatriculation();
}
