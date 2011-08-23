package gestdepartement.metier.comm;

import java.util.List;

public interface IPaysPersistant {
	void ajouterRegion(String nomReg);
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
	 * Liste l'ensemble des departements sous la forme IDepartementConsultable.
	 * @return une collection contenant l'ensemble des departement du metier.
	 */
	List<IDepartementConsultable> listerDepartementsCons();
}
