package cindy.metier.comm;

/**
 * 
 * Interface permettant de récuperer des méthodes de la classe Mission.
 * 
 * @author J.Martinez
 * @version 1.0 du 25/07/2011
 * 
 */
public interface IPiece {

	/**
	 * Recupère le nom de la pièce.
	 * 
	 * @return le nom sous forme de String
	 */
	String getNom();

	/**
	 * Recupère le nombre d'heure de vol.
	 * 
	 * @return le nombre d'heure sous forme d'entier
	 */
	int getNbHeureVol();

	/**
	 * Permet d'ajouter des heures de vol à une piece.
	 * 
	 * @param nombre
	 *            sous forme d'entier
	 */
	void ajouterHeureDeVol(int nombre);
}
