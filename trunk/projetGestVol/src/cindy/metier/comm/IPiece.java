package cindy.metier.comm;

/**
 * 
 * Interface permettant de r�cuperer des m�thodes de la classe Mission.
 * 
 * @author J.Martinez
 * @version 1.0 du 25/07/2011
 * 
 */
public interface IPiece {

	/**
	 * Recup�re le nom de la pi�ce.
	 * 
	 * @return le nom sous forme de String
	 */
	String getNom();

	/**
	 * Recup�re le nombre d'heure de vol.
	 * 
	 * @return le nombre d'heure sous forme d'entier
	 */
	int getNbHeureVol();

	/**
	 * Permet d'ajouter des heures de vol � une piece.
	 * 
	 * @param nombre
	 *            sous forme d'entier
	 */
	void ajouterHeureDeVol(int nombre);
}
