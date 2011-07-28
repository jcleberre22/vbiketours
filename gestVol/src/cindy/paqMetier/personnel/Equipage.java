package cindy.paqMetier.personnel;

import java.util.List;



/**
 * Un equipage possède un pilote et un naviguateur de type PersonnelNaviguant.
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 * 
 */
public class Equipage {
	
	//Attribut
	/** Le pilote d'un equipage*/
	private PersonnelNaviguant pilote;
	
	/** Le naviguateur d'un equipage*/
	private PersonnelNaviguant navigateur;

	/** liste d'un equipage */
	List<PersonnelNaviguant> lst = null;
	
	//constructeur
	/** 
	 * Creation d'un equipage avec le constructeur.
	 * Sur ce constructeur, un equipage contient un pilote et un navigateur
	 * @param1 le pilote de type PersonnelNaviguant
	 * @param2 le navigateur de type PersonnelNaviguant
	 */
	public Equipage(PersonnelNaviguant pilote, PersonnelNaviguant navigateur) {
		super();
		this.setPilote(pilote);
		this.setNavigateur(navigateur);
	}
	
	/** 
	 * Creation d'un equipage avec le constructeur.
	 * Sur ce constructeur, un equipage contient justeu un pilote.
	 * Le setteur navigateur sera à null.
	 * @param1 le pilote de type PersonnelNaviguant
	 * 
	 */
	public Equipage(PersonnelNaviguant pilote) {
		super();
		this.setPilote(pilote);
		this.setNavigateur(null);
	}
	

	//Accesseurs
	private PersonnelNaviguant getPilote() {
		return pilote;
	}

	private void setPilote(PersonnelNaviguant pilote) {
		if(pilote == null){
			throw new RuntimeException("Equipage : Vous essayez d'ajouter null en tant que pilote");
		}
		this.pilote = pilote;
	}

	private PersonnelNaviguant getNavigateur() {
		return navigateur;
	}

	private void setNavigateur(PersonnelNaviguant navigateur) {
		this.navigateur = navigateur;
	}
	
	//Méthode publique
	/**
	 * Méthode qui permet de mettre à jour le nombre d'heure de vol d'un pilote
	 * ou d'un naviguateur.
	 * Il peut ne pas y avoir de naviguateur.
	 */
	public void majHeureVol(int nombre){
		getPilote().ajouterNbHeure(nombre);
		if(getNavigateur() != null)
			getNavigateur().ajouterNbHeure(nombre);
	}
}
