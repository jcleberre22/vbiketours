package gestdepartement.metier.comm;

import java.sql.SQLException;

public interface IPersistance {
	/**
	 * Lit l'ensemble des constituants du conteneur.
	 * @param conteneurx�
	 */
	void lireTous(Object conteneur);
	
	/**
	 * Prevenir le persistance de l'arret de l'application
	 * dans le cas d'une base de donn�es on fera eventuellement un commit;
	 * dans le cas de la gestion par fichier il faudra 
	 * sauvegarder l'etat du metier
	 * @param conteneur
	 */
	void quitter(Object conteneur);
	
	/**
	 * M�thode pour supprimer des objets g�rer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerRegionPersistance(Object obj) throws SQLException, Exception;
	void modifierRegionPersistance(Object obj);
	void insererRegionPersistance(Object obj);
}
