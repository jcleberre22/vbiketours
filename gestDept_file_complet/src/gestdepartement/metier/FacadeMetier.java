package gestdepartement.metier;


import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IPersistance;
import gestdepartement.metier.comm.IUseCase;
import gestdepartement.metier.comm.comparator.DepCompareNom;
import gestdepartement.persistance.FabriquePersistance;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class FacadeMetier implements IUseCase {
	/** la facade naturelle du metier. */
	private Pays lePays;
	
	/** l'acces a la persistance. */
	private IPersistance persistance;
	
	/**
	 * Obtient une instance de la facade naturelle
	 * et la renseigne a partir de la persistance.
	 */
	public FacadeMetier(){
		lePays = new Pays();
		persistance =  FabriquePersistance.getInstance(FabriquePersistance.REGION);
		persistance.lireTous(lePays);
		persistance =  FabriquePersistance.getInstance(FabriquePersistance.DEPARTEMENT);
		persistance.lireTous(lePays);
	}

	public String getNomPays(){
		return lePays.getNom();
	}

	public void ajouterRegion(String nomReg){
		lePays.ajouterRegion(nomReg);
	}

	public void modifierRegion(String region,String nvxNom) throws SQLException, Exception {
		String nom = lePays.modifierRegion(region, nvxNom);
		persistance = FabriquePersistance.getInstance(FabriquePersistance.REGION);
		persistance.modifierRegionPersistance(nom);
	}

	public void supprimerRegion(String nomReg) throws SQLException, Exception {
		int idt = lePays.supprimerRegion(nomReg);
		persistance = FabriquePersistance.getInstance(FabriquePersistance.REGION);
		persistance.supprimerRegionPersistance(idt);
	}

	public List<String> listerRegion() {
		return lePays.listerRegion();
	}

	public List<String> listerDepartements() {
		return lePays.listerDepartements();
	}

	public void ajouterDepartement(String nomReg, String code, String nom,
		int nombreHabitant,	int superficie) {
		lePays.ajouterDepartement(nomReg, code, nom, nombreHabitant, superficie);
	}

	public void supprimerDepartement(String code) {
		lePays.supprimerDepartement(code);
	}

	public void modifierDepartement(String code, String nom,
			int nombreHabitant,	int superficie) {
		lePays.modifierDepartement(code, nom, nombreHabitant, superficie);
	}

	public List<String> listerDepartement(String nomRegion) {
		return lePays.listerDepartement(nomRegion);
	}
	public List<IDepartementConsultable> listerDepartementTries() {
		List<IDepartementConsultable> ret = lePays.listerDepartementsCons();
		Collections.sort(ret,new DepCompareNom());
		return ret;
	}
	/**
	 * Fournit l'etat du departement demandé
	 * sous la forme d'une chaine composé comme suit:
	 * codeDepartement;nomDepartement;nombreHabitant;superficie;densite;nomRegion
	 * @param code du departement recherche
	 * @return l'etat du departement demandé.
	 */
	public String getDepartement(String code) {
		try{
			return lePays.getDepartement(code);
		} catch (Exception e) {
			return lePays.getDepartement(" "+code);
		}
	}
	public void quitter(){
		persistance = FabriquePersistance.getInstance(FabriquePersistance.DEPARTEMENT);
		persistance.quitter(lePays);
	}
	public static void main(String[] args) {
		new FacadeMetier();
	}
}
