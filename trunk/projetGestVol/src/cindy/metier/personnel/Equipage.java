package cindy.metier.personnel;

import java.util.ArrayList;
import java.util.List;

/**
 * Un equipage possède un pilote et un naviguateur de type PersonnelNaviguant.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifié le 26/07/2011
 */

public class Equipage {

	// Attribut
	/** Le pilote d'un equipage */
	private PersonnelNaviguant pilote;

	/** Le naviguateur d'un equipage */
	private PersonnelNaviguant navigateur;

	/** liste d'un equipage */
	private List<Equipage> lst = new ArrayList<Equipage>();

	// constructeur
	/**
	 * Constructeur necessaire pour les tests.
	 */
	public Equipage() {

	}

	/**
	 * Creation d'un equipage avec le constructeur. Sur ce constructeur, un
	 * equipage contient un pilote et un navigateur
	 * 
	 * @param1 le pilote de type PersonnelNaviguant
	 * @param2 le navigateur de type PersonnelNaviguant
	 */
	public Equipage(PersonnelNaviguant pilote, PersonnelNaviguant navigateur) {
		super();
		this.setPilote(pilote);
		this.setNavigateur(navigateur);
	}

	/**
	 * Creation d'un equipage avec le constructeur. Sur ce constructeur, un
	 * equipage contient justeu un pilote. Le setteur navigateur sera à null.
	 * 
	 * @param1 le pilote de type PersonnelNaviguant
	 * 
	 */
	public Equipage(PersonnelNaviguant pilote) {
		super();
		this.setPilote(pilote);
		this.setNavigateur(null);
	}

	// Accesseurs
	public PersonnelNaviguant getPilote() {
		return pilote;
	}

	private void setPilote(PersonnelNaviguant pilote) {
		this.pilote = pilote;
	}

	public PersonnelNaviguant getNavigateur() {
		return navigateur;
	}

	private void setNavigateur(PersonnelNaviguant navigateur) {
		this.navigateur = navigateur;
	}

	// Méthode publique
	/**
	 * Méthode qui permet de mettre à jour le nombre d'heure de vol d'un pilote
	 * ou d'un naviguateur. Il peut ne pas y avoir de naviguateur.
	 */
	public void majHeureVol(int nombre) {

		getPilote().ajouterNbHeure(nombre);
		if (getNavigateur() != null) {
			getNavigateur().ajouterNbHeure(nombre);
		}

	}

	/**
	 * Méthode qui ajouter un equipage dans une liste d'equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	public boolean ajouterEquipage(Equipage equipage) {
		if (lst.contains(equipage) == false) {
			lst.add(equipage);
		} else {
			new RuntimeException(
					"Impossible d'ajouter l'equipage dans la liste car elle existe déjà");
		}
		return false;
	}

}
