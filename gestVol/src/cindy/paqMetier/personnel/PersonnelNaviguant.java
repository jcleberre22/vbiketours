package cindy.paqMetier.personnel;

import cindy.paqMetier.comm.IPersonnelNaviguant;

/**
 * Un pilote pilote 0 ou plusieurs avion.
 * Un pilote possède un identifiant, un nom, un prenom,
 * un grade,
 * @author Nicolas.tabuteaud
 *
 */
public class PersonnelNaviguant implements IPersonnelNaviguant {

	//Attribut privé
	private int id;
	private String nom;
	private String prenom;
	private String grade;
	private String escadron;
	private String qualification;
	private int heureVol;

	//Constructeur

	public PersonnelNaviguant(int id, String nom, String prenom, String grade,
			String escadron, String qualification, int heureVol) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setGrade(grade);
		this.setEscadron(escadron);
		this.setQualification(qualification);
		this.setHeureVol(heureVol);
	}
	
	/**
	 * Constructeur necessaire pour les tests
	 * avec instanciation sous forme de bean.
	 * Les setteurs sont positionnés en public pour la 
	 * meme raison.
	 */
	public PersonnelNaviguant(){
		
	}

	//Accesseur setteur

	/**
	 * L'identifiant d'un pilote ne peut être égal à 0 .
	 * @param identifiant du pilote
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative a l'identifiant d'un pilote
	 */
	private void setId(int id) {
		if(id == 0 ){
			throw new RuntimeException("L'identifiant ne peut être egal à 0");
		}
		this.id = id;
	}

	/**
	 * Le nom d'un pilote doit être non null et non vide.
	 * @param nom du pilote
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative au nom d'un pilote
	 */
	private void setNom(String nom) {
		if (nom == null || nom.trim().length() == 0){
			throw new RuntimeException("Un pilote doit posséder un nom valide");
		}
		this.nom = nom;
	}

	/**
	 * Le prenom d'un pilote doit être non null et non vide.
	 * @param prenom du pilote
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative au prenom d'un pilote
	 */
	private void setPrenom(String prenom) {
		if (prenom == null || prenom.trim().length() == 0){
			throw new RuntimeException("Un pilote doit posséder un prenom valide");
		}
		this.prenom = prenom;
	}

	/**
	 * Le grade d'un pilote doit être non null et non vide.
	 * @param grade du pilote
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative au grade d'un pilote
	 */
	private void setGrade(String grade) {
		if (grade == null || grade.trim().length() == 0){
			throw new RuntimeException("Un pilote doit posséder un grade valide");
		}
		this.grade = grade;
	}

	/**
	 * L'escadron d'un pilote doit être non null et non vide.
	 * @param escadron du pilote
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative a l'escadron d'un pilote
	 */
	public void setEscadron(String escadron) {
		if (escadron == null || escadron.trim().length() == 0){
			throw new RuntimeException("Un pilote doit posséder un escadron valide");
		}
		this.escadron = escadron;
	}

	/**
	 * La qualification d'un pilote doit être non null et non vide.
	 * @param qualification du pilote
	 * @return 
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative au qualification d'un pilote
	 */
	private void setQualification(String qualification) {
		if (qualification == null || qualification.trim().length() == 0){
			throw new RuntimeException("Un pilote doit posséder une qualification valide");
		}
		this.qualification = qualification;
	}

	/**
	 * Les heures de vol ne peuvent être égal à 0 .
	 * @param heures de vol
	 * @throws RuntimeException en cas de non respect de la regle
	 * de gestion relative au heure de vol
	 */
	private void setHeureVol(int heureVol) {
		if(heureVol == 0){
			throw new RuntimeException("Un pilote doit avoir des heures de vols.");
		}
		this.heureVol = heureVol;
	}

	//Accesseur guetteur
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getGrade() {
		return grade;
	}

	public String getEscadron() {
		return escadron;
	}

	public String getQualification() {
		return qualification;
	}

	public int getHeureVol() {
		return heureVol;
	}

	//Redefinition
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pilote [id=").append(getId());
		sb.append(", nom=").append(getNom());
		sb.append(", prenom=").append(getPrenom());
		sb.append(", grade=").append(getGrade());
		sb.append(", escadron=").append(getEscadron());
		sb.append(", qualification=").append(getQualification());
		sb.append(", nombre Heure de vol=").append(getHeureVol());
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonnelNaviguant other = (PersonnelNaviguant) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	} 
	
	//Méthode publique
	/**
	 * Méthode qui permet d'ajouter des heures de vols au pilote.
	 * @param nombre d'heure à ajouter
	 * @return le nombre d'heure de vol sous forme d'entier. 
	 */
	public int ajouterNbHeure(int nombre){
		return this.heureVol += nombre;
		
	}

}


