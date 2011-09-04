package cindy.controleur;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.FacadeMetier;

import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICirculation;
import cindy.metier.comm.IVol;
import cindy.vue.*;


public class Controleur implements IControleur{
	
	private FacadeMetier f;
	private VuePrincipale ihm;
	private APropos app;
	
	public Controleur() throws SQLException, Exception{
		f=new FacadeMetier();
		ihm=new VuePrincipale(this);
		ihm.setVisible(true);

	}
	
	public void creerVol(int idVol, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation) {
		f.creerVol(idVol, circulation, categorieDeVol, dateDecollage, dateAtterrissage, annulation);
	}
	
	public void modifierVol(IVol ancien, IVol nouveau){
		f.modifierVol(ancien, nouveau);
	}

	@Override
	public void supprimerVol(IVol aSupprimer) throws SQLException, Exception {
		f.supprimerVol(aSupprimer);
	}

	@Override
	public List<IVol> getListeVols() throws SQLException, Exception {
		return f.getListeVols();
	}

	@Override
	public List<ICategorie> getListeCategories() throws SQLException, Exception {
		return f.getListeCategories();
	}
	
	@Override
	public List<ICirculation> getListeCirculations() throws SQLException, Exception {
		return f.getListeCirculations();
	}

	@Override
	public void APropos() {
		app = new APropos();
		
	}
}
