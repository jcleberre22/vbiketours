package cindy.metier.personnel;

/**
 * Un equipage possède un pilote et un naviguateur de type PersonnelNaviguant.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifié le 26/07/2011
 */

public class Equipage {

	// Attribut
	/** Le pilote d'un equipage */
	private PersonnelNavigant pilote;

	/** Le naviguateur d'un equipage */
	private PersonnelNavigant navigateur;

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
	public Equipage(PersonnelNavigant pilote, PersonnelNavigant navigateur) {
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
	public Equipage(PersonnelNavigant pilote) {
		super();
		this.setPilote(pilote);
		this.setNavigateur(null);
	}

	// Accesseurs
	public PersonnelNavigant getPilote() {
		return pilote;
	}

	public void setPilote(PersonnelNavigant pilote) {
		this.pilote = pilote;
	}

	public PersonnelNavigant getNavigateur() {
		return navigateur;
	}

	private void setNavigateur(PersonnelNavigant navigateur) {
		this.navigateur = navigateur;
	}

	// Méthode publique
	/**
	 * Méthode qui permet de mettre à jour le nombre d'heure de vol d'un pilote
	 * ou d'un naviguateur car il est possible d'avoir dans le constructeur un
	 * navigateur null.
	 */
	public void majHeureVol(int nombre) {

		if (getPilote() == null) {
			throw new RuntimeException("nombre null");
		} else {
			this.getPilote().ajouterNbHeure(nombre);

		}

		if (getNavigateur() == null) {
			throw new RuntimeException("navigateur null");
		} else {
			this.getNavigateur().ajouterNbHeure(nombre);
		}

	}

}
