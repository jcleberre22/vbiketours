package cindy.metier.comm;

import cindy.metier.personnel.Equipage;

/**
 * Interface permettant de r�cuperer des m�thodes de la classe Equipage.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface IEquipage {

	/**
	 * M�thode qui permet de mettre � jour le nombre d'heure de vol d'un pilote
	 * ou d'un naviguateur. Il peut ne pas y avoir de naviguateur.
	 */
	void majHeureVol(int nombre);

	/**
	 * M�thode qui ajouter un equipage dans une liste d'equipage. Regle on ne
	 * peux ajouter un m�me equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	boolean ajouterEquipage(Equipage equipage);
}
