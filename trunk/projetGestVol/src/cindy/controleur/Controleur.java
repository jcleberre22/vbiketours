package cindy.controleur;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.FacadeMetier;

import cindy.vue.*;

import cindy.metier.comm.IVol;
import cindy.metier.vol.Vol;
import cindy.vue.VuePrincipale;


public class Controleur implements IControleur{
	
	private FacadeMetier f;
	private VuePrincipale ihm;
	private APropos app;
	
	public Controleur() throws SQLException, Exception{
		f=new FacadeMetier();
		ihm=new VuePrincipale(this);
		APropos();
		ihm.setVisible(true);

	}
	
	public void creerVol(int reference, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation) {
		f.creerVol(reference, circulation, categorieDeVol, dateDecollage, dateAtterrissage, annulation);
	}
	
	public void APropos(){
		app = new APropos();
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

}
