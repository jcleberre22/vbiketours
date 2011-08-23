package gestdepartement.metier.comm;

import java.util.List;
/**
 * Interface necessaire au tests de comportement d'un 
 * pays. 
 * @author marc.leconte
 * @version 1.0 du 12/06/2011
 */
public interface IPaysTest {
	/**
	 * @return le nom du pays.
	 * Nous ne gerons qu'un seul pays, le nom est donc toujours
	 * identique.
	 */
	String getNom();
	
	/**
	 * Ajouter la region nommée au pays.
	 * Il n'est pas permis d'ajouter 2 regions de meme
	 * nom.
	 * @param nomReg le nom de la region a ajouter.
	 * @throws un runtime exception en cas d'erreur
	 */
	void ajouterRegion(String nomReg);
	/**
	 * Modifier une region du pays.
	 * La seul emodifiaction possible et de modifier le 
	 * nom de la region.
	 * Il n'est pas permis d'avoir 2 regions avec le meme nom.
	 * @param region le nom de la region a modifier
	 * @param nvxNom le nouveau nom de la region
	 */
	String modifierRegion(String region,String nvxNom);
	
	/**
	 * Suppression d'une region.
	 * La suppression entraine la suppression des
	 * departements de la region.
	 * @param nomReg nom de la region a supprimer.
	 */
	int supprimerRegion(String nomReg);
	
	/**
	 * Liste les regions du pays.
	 * @return la liste des noms des regions du pays.
	 */
	List<String> listerRegion();
	
	/**
	 * Ajouter un departement a une region du pays.
	 * Deux departement avec le meme code ne peuvent 
	 * pas exister au sein du pays.
	 * @param nomReg nom de la region qui recoit le nouveau 
	 * departement
	 * @param code du departement à ajouter 
	 * @param nom du departement à ajouter (non vide)
	 * @param nombreHabitant du departement a ajouter (>0)
	 * @param superficie du departement a ajouter (>0)
	 */
	void ajouterDepartement(String nomReg, String code, String nom,
			int nombreHabitant,	int superficie);
	/**
	 * Liste l'etat des departements d'un pays.
	 * L'ensemble de tous les departements de toutes les
	 * regions du pays.
	 * @return une collection de chaine presentant 
	 * l'etat de l'ensemble des departements du pays.
	 */
	List<String> listerDepartements();
	
	/**
	 * Supprime le departement dont le code est fournit.
	 * Il sera supprime quelque soit sa region de rattachement.
	 * @param code du departement a supprimer
	 */
	void supprimerDepartement(String code);
}
