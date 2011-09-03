package cindy.controleur;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.FacadeMetier;

import cindy.metier.comm.ICategorie;
import cindy.metier.comm.IVol;
import cindy.metier.vol.Vol;
import cindy.vue.VuePrincipale;


public class Controleur implements IControleur{
	
	private FacadeMetier f;
	private VuePrincipale ihm;
	
	public Controleur() throws SQLException, Exception{
		f=new FacadeMetier();
		ihm=new VuePrincipale(this);
		ihm.setVisible(true);

	}
	
	public void creerVol(int reference, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation) {
		f.creerVol(reference, circulation, categorieDeVol, dateDecollage, dateAtterrissage, annulation);
	}
	
	public void modifierVol(Vol ancien, Vol nouveau){
		f.modifierVol(ancien, nouveau);
	}

	@Override
	public void supprimerVol(Vol aSupprimer) {
		
	}

	@Override
	public List<IVol> getListeVols() throws SQLException, Exception {
		return f.getListeVols();
	}

	@Override
	public List<ICategorie> getListeCategories() throws SQLException, Exception {
		return f.getListeCategories();
	}

}
