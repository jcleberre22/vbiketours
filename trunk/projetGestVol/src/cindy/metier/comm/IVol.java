package cindy.metier.comm;

/**
 * 
 * Interface permettant de r�cuperer des m�thodes de la classe Vol.
 * 
 * @author J.Martinez
 * @version 1.0 du 25/07/2011
 * 
 */
public interface IVol {

	/**
	 * Recupere la reference d'un vol.
	 * 
	 * @return reference sous forme de String
	 */
	String getReference();

	/**
	 * Recupere la circulation adopt�e pour le vol.
	 * 
	 * @return circulation sous forme de String
	 */
	String getCirculation();

	/**
	 * ajoute une sortie aerienne au vol
	 * 
	 * @param laSortie
	 */
	void ajouterCategorie(String nomCategorie);

}
