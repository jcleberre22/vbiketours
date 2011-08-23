package gestdepartement.metier.comm;

import java.sql.SQLException;
import java.util.List;

public interface IUseCase {
	/**
	 * @return le nom du pays.
	 */
	String getNomPays();
	/**
	 * Ajouter une region au pays.
	 * @param nomReg nom de la region a ajouter.
	 */
	void ajouterRegion(String nomReg);
	
	/**
	 * Modifier la region, on change son nom.
	 * @param region ancien nom de la region
	 * @param nvxNom nouveau nom.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void modifierRegion(String region,String nvxNom) throws SQLException, Exception;
	
	/**
	 * Supprimer la region nommée.
	 * @param nomReg nom de la region a supprimer.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerRegion(String nomReg) throws SQLException, Exception ;
	
	/**
	 * Lister le nom des region connu du pays.
	 * @return une collection de nom de region
	 */
	List<String> listerRegion();
	/**
	 * Lister les departement du pays.
	 * @return une collection des departements
	 * du pays, chaque departement est serialiser sous la forme
	 * d'une chaine avec ";" comme séparateur de champs.
	 */
	List<String> listerDepartements();
	
	/**
	 * Ajouter un departement a une region.
	 * @param nomReg nom de la region qui porte le departement
	 * @param code du departement a ajouter
	 * @param nom du departement
	 * @param nombreHabitant du departement.
	 * @param superficie du departement.
	 */
	void ajouterDepartement(String nomReg, String code, String nom,
			int nombreHabitant,	int superficie);
	
	/**
	 * Supprimer le departement du pays.
	 * @param code du departement a supprimer
	 */
	void supprimerDepartement(String code);
	
	/**
	 * Modifier les informlations du departement.
	 * Le code departement n'est pas modifiable il faut supprimer 
	 * le departement et le recréer si necessaire.
	 * @param code du departement a modifier
	 * @param nom a attribuer au departement
	 * @param nombreHabitant a affecter au departement
	 * @param superficie a affecter au departement
	 */
	void modifierDepartement(String code, String nom,
			int nombreHabitant,	int superficie);
	
	/**
	 * Liste les departements d'une region.
	 * @param nomRegion dont on cherche la liste les departements
	 * @return une collection des departement de la region,
	 * chaque departement est serialisé dans une chaine avec ";" 
	 * comme separateur.
	 */
	List<String> listerDepartement(String nomRegion);
	
	/**
	 * Liste l'ensemble des departements.
	 * @return une collection contenant l'ensemble des departements
	 * sous la forme de departementConsultable.
	 */
	List<IDepartementConsultable> listerDepartementTries();
	
	/**
	 * Fournit les informations d'un departement.
	 * @param code du departement recherché
	 * @return une chaine contenant le departement serialise.
	 */
	String getDepartement(String code);
	/**
	 * Quitter l'application.
	 */
	void quitter();
}
