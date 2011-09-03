package cindy.metier.comm;

import java.sql.SQLException;
import java.util.List;

public interface ICategoriePersistant {

	public void lire() throws SQLException, Exception;

	public void supprimerPersistance(Object obj) throws SQLException, Exception;

	public void modifierPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

	public void insererPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

	public List<ICategorie> getListeCategories() throws SQLException, Exception;

}
