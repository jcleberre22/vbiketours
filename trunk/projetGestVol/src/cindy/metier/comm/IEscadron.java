package cindy.metier.comm;

import java.util.ArrayList;

/**
 * Interface permettant de récuperer des méthodes de la classe Escadron.
 * 
 * @author JC.Leberre
 * @version 1.0 du 27/07/2011
 */
import cindy.metier.personnel.Equipage;
import cindy.metier.personnel.PersonnelNavigant;

/**
 * Interface permettant de récuperer des méthodes de la classe Escadron.
 * 
 * @author JC.leberre
 * @version 1.0 du 25/07/2011 modifié by nicolas.tabuteaud
 * 
 */
public interface IEscadron {
	/**
	 * Recupere une liste de pilote dans l'escadron.
	 * 
	 * @return les pilotes sous forme de liste.
	 */
	public ArrayList<PersonnelNavigant> getPilotes();

	/**
	 * Recupere le nom d'un escadron.
	 * 
	 * @return nom d'un escadron sous forme de String.
	 */
	public String getNomEscadron();

	/**
	 * Méthode qui ajouter un equipage dans une liste d'equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	public boolean ajouterEquipage(Equipage eq);

	/**
	 * Méthode qui supprimer un equipage dans une liste d'equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	public boolean supprimerEquipage(Equipage eq);
}