package cindy.controleur;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICirculation;
import cindy.metier.comm.IVol;

public interface IControleur {
	public void creerVol(int idVol, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation);
	public void modifierVol(IVol vol, IVol nouveauVol);
	public void supprimerVol(IVol aSupprimer) throws SQLException, Exception;
	public List<IVol> getListeVols() throws SQLException, Exception;
	public List<ICategorie> getListeCategories() throws SQLException, Exception;
	List<ICirculation> getListeCirculations() throws SQLException, Exception;
	public void APropos();
}
