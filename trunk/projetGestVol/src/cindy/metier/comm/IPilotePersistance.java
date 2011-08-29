package cindy.metier.comm;

import java.sql.SQLException;

public interface IPilotePersistance {


	/**
	 * Méthode pour supprimer des objets gérer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void lire() throws SQLException, Exception;
	
	/**
	 * Méthode pour supprimer des objets gérer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerPersistance(Object obj) throws SQLException, Exception;
	
	/**
	 * Méthode pour modifier des objets gérer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */

	void modifierPersistance(Object obj, Object obj2) throws SQLException,
			Exception;
	
	/**
	 * Méthode pour inserer des objets gérer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void insererPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

}

