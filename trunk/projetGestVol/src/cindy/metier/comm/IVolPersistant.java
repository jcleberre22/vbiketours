package cindy.metier.comm;

import java.sql.SQLException;

/**
 * 
 * Interface permettant de récuperer des méthodes de la DAO Vol.
 * 
 * @author jc.leberre
 * @version 1.0 du 30/08/2011
 * 
 */
public interface IVolPersistant {

	/**
	 * Méthode pour supprimer des objets gérer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void lire() throws SQLException, Exception;

	/**
	 * Méthode pour supprimer des objets gérer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerPersistance(Object obj) throws SQLException, Exception;

	/**
	 * Méthode pour modifier des objets gérer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6) throws SQLException, Exception;


	/**
	 * Méthode pour inserer des objets gérer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6) throws SQLException, Exception;


}
