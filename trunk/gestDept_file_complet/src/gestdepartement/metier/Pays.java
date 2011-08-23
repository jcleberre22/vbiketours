package gestdepartement.metier;

import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IPaysPersistant;
import gestdepartement.metier.comm.IPaysTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Facade naturelle de l'application.
 * Le pays sera positionner sur la france puisque notre application ne gere
 * que l'ensemble des régions et departements francais.
 * @author marc.leconte
 * @version 1.0
 */
class Pays implements IPaysTest, IPaysPersistant{
	/** le nom du pays.*/
	private String nom;

	/** l'ensembles des regions du pays.*/
	private Set<Region> lesRegions;

	public Pays(){
		nom="France";
		lesRegions = new HashSet<Region>();
	}
	//ACCESSEURS
	public String getNom() {
		return nom;
	}
	//METHODES PUBLIQUES
	public void ajouterRegion(String nomReg) {
		Region reg = new Region(nomReg);
		if (lesRegions.contains(reg)) {
			throw new RuntimeException("cette region existe déjà !");
		}	
		lesRegions.add(reg);
	}
	 
	public String modifierRegion(String region,String nvxNom){
		Region regNvx = new Region(nvxNom);
		if (lesRegions.contains(regNvx)){
			throw new RuntimeException("ce nom de region existe déjà !");
		}

		Region reg = rechercherRegion(region);
		if (reg == null) {
			throw new RuntimeException("La region a modifier n'existe pas!!");
		}
		reg.setNom(nvxNom);
		return reg.getNom();
	}

	
	public int supprimerRegion(String nomReg) {
		Region reg = rechercherRegion(nomReg);
		if (reg == null) {
			throw new RuntimeException("La region a supprimer n'existe pas!!");
		}
		reg.supprimer();
		lesRegions.remove(reg);
		return reg.getIdt();
	}
	
	public List<String> listerRegion() {
		List<String> ret = new ArrayList<String>();
		Iterator<Region> it = lesRegions.iterator();
		while (it.hasNext()){
			ret.add(it.next().getNom());
		}
		return ret;
	}

	public void ajouterDepartement(String nomReg, String code, String nom,
			int nombreHabitant,	int superficie) {
		Region reg = rechercherRegion(nomReg);
		if (reg == null) {
			throw new RuntimeException("La region n'existe pas!!");
		}
		
		if (isDepartementExiste(code)){
			throw new RuntimeException("Ce code departement existe déjà !!");
		}
		reg.ajouterDepartement(code, nom, nombreHabitant, superficie);
	}
	
	public List<String> listerDepartements() {
		List<String> ret = new ArrayList<String>();
		Iterator<Region> it = lesRegions.iterator();
		while (it.hasNext()){
			Region reg = it.next();
			ret.addAll(reg.listerDepartement());
		}
		return ret;
	}
	public List<IDepartementConsultable> listerDepartementsCons() {
		List<IDepartementConsultable> ret = new ArrayList<IDepartementConsultable>();
		Iterator<Region> it = lesRegions.iterator();
		while (it.hasNext()){
			Region reg = it.next();
			ret.addAll(reg.getLesDepartements());
		}
		return ret;
	}

	public void supprimerDepartement(String code) {
		if (isDepartementExiste(code) == false) {
			throw new RuntimeException("Ce code departement n'existe pas !!");
		}
		Region reg = getRegionContenant(code);
		reg.supprimerDepartement(code);
	}
	
	public void modifierDepartement(String code, String nom,
			int nombreHabitant,	int superficie) {
		if (isDepartementExiste(code) == false) {
			throw new RuntimeException("Ce code departement n'existe pas !!");
		}
		Region reg = getRegionContenant(code);
		reg.modifierDepartement(code, nom, nombreHabitant, superficie);
	}
	
	
	public List<String> listerDepartement(String nomRegion) {
		Region reg = rechercherRegion(nomRegion);
		if (reg==null){
			throw new RuntimeException ("region inconnue!!");
		}
		return reg.listerDepartement();
	}
	
	public String getDepartement(String code) {
		Region reg = getRegionContenant(code);
		if (reg == null){
			throw new RuntimeException("Code departement inconnu !!");
		}
		Departement dept = reg.getDepartement(code);
		return dept.etat();
	}
	
	//METHODES PRIVEES
	private Region getRegionContenant(String code) {
		Iterator<Region> it = lesRegions.iterator();
		boolean trouve = false;
		Region reg = null;

		while(it.hasNext() && trouve == false) {
			reg = it.next();
			trouve = reg.isCodePresent(code);
		}
		if (trouve) {
			return reg;
		}
		return null;
	}
	//rechercher un departements dans toutes les regions
	private boolean isDepartementExiste(String code) {
		Iterator<Region> it = lesRegions.iterator();
		boolean trouve = false;
		while(it.hasNext() && trouve == false) {
			Region reg = it.next();
			trouve = reg.isCodePresent(code);
		}
		return trouve;
	}
	
	/**
	 * Fournit la region correspondant au nom fournit.
	 * @param nomRegion a rechercher.
	 * @return la region portant le nom fournit ou 
	 * null si aucune region ne porte ce nom.
	 */
	private Region rechercherRegion(String nomRegion) {
		Iterator<Region> it = lesRegions.iterator();
		boolean trouve = false;
		Region recherche = null;
		while(it.hasNext() && trouve==false) {
			Region reg = it.next();
			if (reg.getNom().equals(nomRegion)){
				trouve = true;
				recherche = reg;
			} 
		}
		return recherche;
	}
}