package cindy.controleur;

import java.util.GregorianCalendar;

import cindy.metier.FacadeMetier;
import cindy.metier.vol.Vol;
import cindy.vue.VuePrincipale;

public class Controleur implements IControleur{
	
	private FacadeMetier f;
	private VuePrincipale ihm;
	
	public Controleur(){
		f=new FacadeMetier();
		ihm=new VuePrincipale(this);
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
	
}
