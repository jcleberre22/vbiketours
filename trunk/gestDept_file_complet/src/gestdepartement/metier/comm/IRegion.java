package gestdepartement.metier.comm;

import java.util.List;

public interface IRegion {

	/** @return le nom du departement. */
	String getNom();
	/**
	 *  Ajoute le departement a la region.
	 *  Regle on ne peut pas ajouter 2 departements ayant le meme
	 *  code.
	 *  Regle on ne peut ajouter un departement que si il est 
	 *  valid.
	 *  @param code du d�partement a ajouter
	 *  @param nom du departement a creer
	 *  @param nombreHabitant du departement a ajouter a la region
	 *  @param superficie du departement a ajouter
	 */
	void ajouterDepartement(String code, String nom,
			int nombreHabitant,	int superficie);
	/**
	 * @return la liste des departement de la region ou une liste
	 * vide. La liste est compos�e de chaine contenant la serialisation
	 * des d�partements sous la forme d'une chaine avec ";" comme s�parateur.
	 */
	 List<String> listerDepartement();
	 
	 /**
	  * Supprime le departement dont le code est pass� en parametre.
	  * @throws une runtime exception si le departement n'est pas
	  * present dans la region.
	  * @param code du departement a supprimer.
	  */
	 void supprimerDepartement(String code);
	 /**
	  * Modifie les informations du departement.
	  * La modificatiuon sera r�alis�e compl�tement ou pas du tout.
	  * @throws un runtimeException si la modification ne peut �tre
	  * r�alis�e.
	  * @param code du departement a modifier, le code n'est
	  * pas modifiable.
	  * @param nom a affecter au departement.
	  * @param nombreHabitant a affecter au d�partement
	  * @param superficie a affecter au d�partement
	  */
	 void modifierDepartement(String code, String nom, int nombreHabitant,
				int superficie);
	 /**
	  * Supprime la region et l'ensemble des departement port�e
	  * par cette region.
	  * On libere les liens crois�s pour faciliter la tache du garbage collector.
	  */
	 void supprimer();
}
