package gestdepartement.metier;

import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IDepartementTest;
import gestdepartement.metier.comm.IRegion;
import gestdepartement.metier.comm.exception.RECodeDeptNull;
import gestdepartement.metier.comm.exception.RENomDeptNull;
import gestdepartement.metier.comm.exception.RENombreHabErr;
import gestdepartement.metier.comm.exception.RESuperficieErr;

/**
 * Un departement connait sa region d'appartenance, il
 * possede un nom un code une population et une superficie.
 * @author marc.leconte
 * @version 1.0
 */
class Departement implements IDepartementTest,IDepartementConsultable {
	/** code du departement (numero avec cas 2a et 2b). */
	private String code;
	
	/** le nom du département, il sera toujours stocké sous la forme minuscule. */
	private String nom;
	
	/** le nombre d'habitant, variable d'année en année. */
	private int nombreHabitant;

	/** la region d'appartenance du departement.
	 * Relation avec le departement en esclave. */
	private IRegion appartenance;
	
	/** la superficie du departement.*/
	private int superficie;

	/**
	 * Construit un departement avec les parametres fournit.
	 * @param code
	 * @param nom
	 * @param nombreHabitant
	 * @param regionAppartenance
	 * @param superficie
	 */
	public Departement(String code, String nom, int nombreHabitant,
			Region regionAppartenance, int superficie) {
		setCode(code);
		setNom(nom);
		setNombreHabitant(nombreHabitant);
		appartenance = regionAppartenance;
		setSuperficie(superficie);
	}
	/**
	 * Constructeur necessaire pour les tests
	 * avec instanciation sous forme de bean.
	 * Les setteurs sont positionnés en public pour la 
	 * meme raison.
	 */
	public Departement(){
	}

	//ACCESSEURS
	public String getCode() {
		return code;
	}

	public void setCode(String pCode) {
		if (pCode == null || pCode.trim().length()==0){
			throw new RECodeDeptNull();
		}
		
		code = pCode.replace(";", " ");
	}

	public String getNom() {
		StringBuffer sb = new StringBuffer();
		sb.append(nom.toUpperCase().charAt(0));
		sb.append(nom.substring(1).toLowerCase());
		return sb.toString();
	}

	public void setNom(String pNom) {
		if (pNom == null || pNom.trim().length()==0){
			throw new RENomDeptNull();
		}
		nom = pNom.toLowerCase().replace(";", " ");
	}

	public int getNombreHabitant() {
		return nombreHabitant;
	}

	public void setNombreHabitant(int pNombreHabitant) {
		if (pNombreHabitant < 1) {
			throw new RENombreHabErr();
		}
		nombreHabitant = pNombreHabitant;
	}

	/**
	 * On ne fournit que le nom de la region d'appartenance.
	 * Ce nom constitue la clef candidate des objets departements.
	 * @return le nom du departement
	 */
	public String getAppartenance() {
		return appartenance.getNom();
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int pSuperficie) {
		if (pSuperficie < 1) {
			throw new RESuperficieErr();
		}
		superficie = pSuperficie;
	}
	
	public void setAppartenance(IRegion appartenance) {
		this.appartenance = appartenance;
	}
	
	//METHODES PUBLIQUES
	public void supprimer(){
		appartenance = null;
	}
	public float getDensite(){
		return (float)nombreHabitant / (float)superficie;
	}
	/**
	 * Generation du hascode en focntion du code du departement.
	 * @return un code generée a partir du code du departement.
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/**
	 * @return l'etat de linstance sous la forme de chaine.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Departement [code=").append(code);
		sb.append(", nom=").append(nom);
		sb.append(", nombreHabitant=").append(nombreHabitant);
		sb.append(", appartenance=").append(getAppartenance());
		sb.append(", superficie=").append(superficie).append("]");
		return sb.toString();
	}

	public String etat(){
		StringBuilder sb = new StringBuilder();
		sb.append(code).append(";");
		sb.append(nom).append(";");
		sb.append(nombreHabitant).append(";");
		sb.append(superficie).append(";");
		sb.append(getDensite()).append(";");
		sb.append(getAppartenance());
		return sb.toString();
	}
	
	/**
	 * redefinition d'equals par generation en fonction du
	 * code du departement.
	 * @param obj a comparer avec l'instance actuelle
	 * @return true si le parametre possede le meme hascode que l'instance
	 * actuelle
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departement other = (Departement) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
