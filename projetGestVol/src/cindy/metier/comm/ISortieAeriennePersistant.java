package cindy.metier.comm;

import java.sql.SQLException;

/**
 * 
 * Interface permettant de récuperer des méthodes de la DAO SortieAerienne.
 * 
 * @author jc.leberre
 * @version 1.0 du 30/08/2011
 * 
 */
public interface ISortieAeriennePersistant {

	/**
	 * Méthode pour supprimer des objets gérer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void supprimerPersistance(Object obj) throws SQLException, Exception;

	/**
	 * Méthode pour supprimer des objets gérer par les DAO.
	 * @param obj
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void lire() throws SQLException, Exception;

	/**
	 * Méthode pour modifier des objets gérer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6, Object obj7, Object obj8, Object obj9,
			Object obj10, Object obj11) throws SQLException, Exception;

	/**
	 * Méthode pour inserer des objets gérer par les DAO.
	 * @param obj
	 * @param obj[n]
	 * @throws Exception 
	 * @throws SQLException 
	 */
	void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4,
			Object obj5, Object obj6, Object obj7, Object obj8, Object obj9,
			Object obj10, Object obj11) throws SQLException, Exception;

}
