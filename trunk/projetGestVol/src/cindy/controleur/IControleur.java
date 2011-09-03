package cindy.controleur;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.comm.ICategorie;
import cindy.metier.comm.IVol;
import cindy.metier.vol.Vol;

public interface IControleur {
	public void creerVol(int reference, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation);
	public void modifierVol(Vol ancien, Vol nouveau);
	public void supprimerVol(Vol aSupprimer);
	public List<IVol> getListeVols() throws SQLException, Exception;
	public List<ICategorie> getListeCategories() throws SQLException, Exception;
}
