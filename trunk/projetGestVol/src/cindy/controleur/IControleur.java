package cindy.controleur;

import java.sql.SQLException;
import java.util.List;

import cindy.metier.comm.IVol;
import cindy.metier.vol.Vol;

public interface IControleur {
	public void supprimerVol(Vol aSupprimer);
	public void APropos();
	public List<IVol> getListeVols() throws SQLException, Exception;
}
