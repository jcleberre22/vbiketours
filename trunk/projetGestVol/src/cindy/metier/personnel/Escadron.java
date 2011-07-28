package cindy.metier.personnel;

import java.util.ArrayList;

import cindy.metier.comm.IEscadron;

/**
 * Classe Escadron. Classe permettant de gerer les differents escadrons de la
 * base
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */
public class Escadron implements IEscadron {
	private ArrayList<PersonnelNavigant> pilotes = new ArrayList<PersonnelNavigant>();
	private ArrayList<Equipage> equipage = new ArrayList<Equipage>();
	private String nomEscadron;

	/**
	 * Constructeur de la classe Escadron
	 * 
	 * @param nomEscadron
	 * @param liste
	 *            equipage
	 */
	public Escadron(String nomEscadron, ArrayList<PersonnelNavigant> equipage) {
		setNomEscadron(nomEscadron);
		setPilotes(equipage);
	}

	// GETTERS PUBLIQUES
	/**
	 * Recupere une liste de pilote dans l'escadron.
	 * 
	 * @return les pilotes sous forme de liste.
	 */
	public ArrayList<PersonnelNavigant> getPilotes() {
		return pilotes;
	}

	/**
	 * Recupere le nom d'un escadron.
	 * 
	 * @return nom d'un escadron sous forme de String.
	 */
	public String getNomEscadron() {
		return nomEscadron;
	}

	// SETTERS PRIVES
	public void setPilotes(ArrayList<PersonnelNavigant> pilotes) {
		if (pilotes == null) {
			throw new RuntimeException("liste des pilotes null");
		} else {
			this.pilotes = pilotes;
		}
	}

	public void setNomEscadron(String nomEscadron) {
		if (nomEscadron == null) {
			throw new RuntimeException("nom d'escadron null");
		} else {
			this.nomEscadron = nomEscadron;
		}
	}

	// Methode public
	/**
	 * Méthode qui ajouter un equipage dans une liste d'equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	public boolean ajouterEquipage(Equipage eq) {
		if (eq == null) {
			throw new RuntimeException(
					"Impossible d'ajouter rien, il faut renseigner le champ");
		}
		if (equipage.contains(eq) == false) {
			equipage.add(eq);
			return true;
		} else {
			new RuntimeException(
					"Impossible d'ajouter l'equipage dans la liste car elle existe déjà");
		}
		return false;
	}

	/**
	 * Méthode qui supprimer un equipage dans une liste d'equipage.
	 * 
	 * @param equipage
	 *            de la classe equipage
	 * @return false si l'ajout n'est pas fait
	 */
	public boolean supprimerEquipage(Equipage eq) {
		if (equipage.contains(eq)) {
			equipage.remove(eq);
			return true;
		} else {
			new RuntimeException(
					"Impossible d'ajouter l'equipage dans la liste car elle existe déjà");
		}
		return false;
	}

}
