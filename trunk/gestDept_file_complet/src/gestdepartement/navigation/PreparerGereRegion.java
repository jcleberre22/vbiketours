package gestdepartement.navigation;

import java.util.Collections;
import java.util.List;

import gestdepartement.metier.FacadeMetier;
import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;
/**
 * Recherche la liste des region pour offrir
 * le choix de la region a gerer.
 * @author marc.leconte
 * @version 1.0 du 14/06/2011
 */
public class PreparerGereRegion implements IControleur {


	public Reponse construireReponse(Requete requete) {
		FacadeMetier fac = getFacade();
		List<String> lesRegions = fac.listerRegion();
		Reponse rep = new Reponse("choixRegion");
		Collections.sort(lesRegions);
		rep.setAttribut("regions", lesRegions);
		return rep;
	}

	private FacadeMetier getFacade() {
		Contexte ctx = Contexte.getInstance();
		Object obj = ctx.getSession("metier");
		return (FacadeMetier) obj;
	}

}
