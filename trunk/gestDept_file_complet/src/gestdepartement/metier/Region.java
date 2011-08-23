package gestdepartement.metier;

import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IRegion;
import gestdepartement.metier.comm.IRegionPersistant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Une region est composé de 0 a n departement.
 * Une region possède un nom.
 * @author marc.leconte
 * @version 1.0
 */
class Region implements IRegion, IRegionPersistant {
	/** le nom de la region. */
	private String nom;
private int idt;

	/** les departements d'une region.*/
	private Map<String,Departement> lesDepartements;

	//CONSTRUCTEUR
	public Region(String nom,int idt){
		setIdt(idt);
		setNom(nom);
		lesDepartements = new TreeMap<String, Departement>();
	}
	public Region(String nom){
		setIdt(-1);
		setNom(nom);
		lesDepartements = new TreeMap<String, Departement>();
	}
	public Region(){
		setIdt(-1);
		nom="defaut";
		lesDepartements = new TreeMap<String, Departement>();
	}
	//ACCESSEURS
	@Override
	public int getIdt() {
		return idt;
	}
	public void setIdt(int idt) {
		this.idt = idt;
	}
	/**
	 * Le nom d'une région doit etre non null et non vide.
	 * @param nom2 de la region
	 * @throw RuntimeException en cas de nom respet de la regle
	 * de gestion relative au nom d'une region
	 */
	public void setNom(String nom2) {
		if (nom2 == null || nom2.trim().length() == 0){
			throw new RuntimeException("Une region doit possèder un nom valide !!");
		}
		nom = nom2;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Le 'C' de crud creation d'un departement dans la region.
	 * @param code
	 * @param nom
	 * @param nombreHabitant
	 * @param superficie
	 */
	public void ajouterDepartement(String code, String nom, int nombreHabitant,
			int superficie){
		if (isCodePresent(code)){
			throw new RuntimeException("Ce code departement existe déjà !!");
		}
		Departement dept = new Departement(code, nom, nombreHabitant, this, superficie);
		lesDepartements.put(code, dept);
	}

	/**
	 * le 'R' de crud, liste l'ensemble des departements de la region 
	 * @return le liste de l'etat des departements.
	 */
	public List<String> listerDepartement() {
		Collection<Departement> col = lesDepartements.values();
		List<String> ret = new ArrayList<String>();
		Iterator<Departement> id = col.iterator();
		while (id.hasNext()){
			ret.add(id.next().etat());
		}
		return  ret;
	}
	public List<? extends IDepartementConsultable> getLesDepartements() {
		Collection<Departement> col = lesDepartements.values();
		return new ArrayList<IDepartementConsultable>(col);
	}
	public void supprimerDepartement(String code){
		if (isCodePresent(code) == false){
			throw new RuntimeException("Ce code departement n'existe pas !!");
		}
		Departement dept = lesDepartements.get(code);
		dept.supprimer();
		lesDepartements.remove(code);
	}

	public void modifierDepartement(String code, String nom, int nombreHabitant,
			int superficie){
		if (isCodePresent(code) == false){
			throw new RuntimeException("Ce departement n'existe pas !!");
		}
		Departement dept = new Departement(code, nom, nombreHabitant, this, superficie);
		lesDepartements.put(code, dept);
	}

	public boolean isCodePresent(String code){
		return lesDepartements.containsKey(code);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	/**
	 * Supprimer la region.
	 * Pour permettre la suppression de la region il est necessaire 
	 * de suprimer l'ensemble des departement relier
	 */
	public void supprimer(){
		Set<String> lesCodes = lesDepartements.keySet();
		List<String> copie = new ArrayList<String>(lesCodes);
		Iterator<String> ic = copie.iterator();
		while(ic.hasNext()) {
			supprimerDepartement(ic.next());
		}
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Region [nom=").append(nom);
		sb.append(" nb de departement=").append(lesDepartements.size());
		Collection<Departement> col = lesDepartements.values();
		Iterator<Departement> id = col.iterator();
		while (id.hasNext()){
			sb.append(id.next());
		}
		sb.append("]");
		return sb.toString();
	}

	public Departement getDepartement(String code) {
		return lesDepartements.get(code);
	}
	@Override
	public void ajouterDepartement(int idt, String code, String nom,
			int nombreHabitant, int superficie) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
}
