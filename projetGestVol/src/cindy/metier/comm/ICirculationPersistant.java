package cindy.metier.comm;

import java.sql.SQLException;
import java.util.List;

public interface ICirculationPersistant {

	public void lire() throws SQLException, Exception;

	public void supprimerPersistance(Object obj) throws SQLException, Exception;

	public void modifierPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

	public void insererPersistance(Object obj, Object obj2) throws SQLException,
			Exception;

	public List<ICirculation> getListeCirculations() throws SQLException, Exception;

}
