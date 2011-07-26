package cindy.metier.comm;

/**
 * Interface permettant de r�cuperer des m�thodes de la classe Avion.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IAvion {

	/**
	 * M�thode qui retourne le nom de l'avion.
	 * 
	 * @return le nom de l'avion
	 */
	String getNom();

	/**
	 * M�thode qui retourne le type de l'avion
	 * 
	 * @return le type d'avion sous forme de String
	 */
	String getType();

	/**
	 * M�thode qui retourne l'immatriculation
	 * 
	 * @return l'immatriculation de l'avion sous forme de String
	 */
	String getImmatriculation();
}
