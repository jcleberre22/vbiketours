package cindy.metier.comm;

import java.sql.SQLException;

/**
 * 
 * Interface permettant de r�cuperer des m�thodes des DAOs.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 * 
 */
public interface IPersistance {


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

