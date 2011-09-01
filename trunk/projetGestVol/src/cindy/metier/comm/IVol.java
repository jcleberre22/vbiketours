package cindy.metier.comm;

import java.util.GregorianCalendar;

/**
 * 
 * Interface permettant de récuperer des méthodes de la classe Vol.
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
	 * Recupere la circulation adoptée pour le vol.
	 * 
	 * @return circulation sous forme de String
	 */
	int getCirculation();
	
	public int getId();
	
	public int getLaCategorie();
	
	public GregorianCalendar getDecollage();
	
	public GregorianCalendar getAtterrissage();
	
	public boolean isAnnulation();

	/**
	 * ajoute une sortie aerienne au vol
	 * 
	 * @param laSortie
	 */
	void ajouterCategorie(String nomCategorie);

}
