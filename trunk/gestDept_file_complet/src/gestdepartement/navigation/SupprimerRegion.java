package gestdepartement.navigation;

import gestdepartement.metier.FacadeMetier;
import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class SupprimerRegion implements IControleur{

	
	public Reponse construireReponse(Requete requete) {
		Contexte ctx = Contexte.getInstance();
		Object obj = ctx.getSession("metier");
		FacadeMetier fac = (FacadeMetier) obj;
		String region = ctx.getSession("nomRegion").toString();
		try{
			fac.supprimerRegion(region);
			Demarrer ctl= new Demarrer();
			ctx.setSession("nomRegion",null);
			System.out.println("suppression ok");
			return ctl.construireReponse(requete);
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
