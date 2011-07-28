package cindy.metier.comm;

/**
 * Interface permettant de récuperer des méthodes de la classe Evenement.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IEvenement {

	/**
	 * Recupere le nom de l'evenement.
	 * 
	 * @return le nom de l'evenement sous forme de String
	 */
	public String getNomEvent();

	/**
	 * Recupere le type de l'evenement.
	 * 
	 * @return le type de l'evenement sous forme de String
	 */
	public String getTypeEvent();

}
