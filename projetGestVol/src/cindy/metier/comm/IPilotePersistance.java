package cindy.metier.comm;

import java.sql.SQLException;

public interface IPilotePersistance {


	/**
	 * M�thode pour supprimer des objets g�rer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void lire() throws SQLException, Exception;
	
	/**
	 * M�thode pour supprimer des objets g�rer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerPersistance(Object obj) throws SQLException, Exception;
	
	/**
	 * M�thode pour modifier des objets g�rer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */

	void modifierPersistance(Object obj, Object obj2) throws SQLException,
			Exception;
	
	/**
	 * M�thode pour inserer des objets g�rer par les DAO
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void insererPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

}

