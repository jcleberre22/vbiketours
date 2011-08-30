package cindy.metier.comm;

import java.sql.SQLException;

/**
 * 
 * Interface permettant de r�cuperer des m�thodes de la DAO Vol.
 * 
 * @author jc.leberre
 * @version 1.0 du 30/08/2011
 * 
 */
public interface IVolPersistant {

	/**
	 * M�thode pour supprimer des objets g�rer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void lire() throws SQLException, Exception;

	/**
	 * M�thode pour supprimer des objets g�rer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerPersistance(Object obj) throws SQLException, Exception;

	/**
	 * M�thode pour modifier des objets g�rer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6) throws SQLException, Exception;


	/**
	 * M�thode pour inserer des objets g�rer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6) throws SQLException, Exception;


}
