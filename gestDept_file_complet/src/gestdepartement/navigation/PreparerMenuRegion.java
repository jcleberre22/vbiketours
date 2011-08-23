package gestdepartement.navigation;

import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;
/**
 * Routage simple vers le menu de gestion 
 * d'une region.
 * On place la region selectionnée dans la session.
 * @author marc.leconte
 * @version 1.0 du 14/06/2011
 */
public class PreparerMenuRegion implements IControleur {


	public Reponse construireReponse(Requete requete) {
		Object ob = requete.getParametre("nomRegion");
		Contexte ctx = Contexte.getInstance();
		ctx.setSession("nomRegion", ob);
		return new Reponse("menuRegion");
	}

}
