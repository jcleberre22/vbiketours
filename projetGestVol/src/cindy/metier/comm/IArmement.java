package cindy.metier.comm;

/**
 * Interface permettant de r�cuperer des m�thodes de la classe Armement.
 * 
 * @author jean-philippe martinez
 * @version 1.0 du 25/07/2011
 */
public interface IArmement {

	/**
	 * Retourne le nom de l'armement.
	 * 
	 * @param type
	 *            de type entier
	 */
	public int getType();

	/**
	 * Retourne la description d'un armement.
	 * 
	 * @return la description associ� � un armement
	 */
	public String getDescriptionArmement();

}
