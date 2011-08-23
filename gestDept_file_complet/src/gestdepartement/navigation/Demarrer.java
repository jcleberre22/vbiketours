package gestdepartement.navigation;

import gestdepartement.metier.FacadeMetier;

import org.apache.log4j.Logger;

import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class Demarrer  implements IControleur{
	private static final Logger LOG = Logger.getLogger(Demarrer.class);

	@Override
	public Reponse construireReponse(Requete requete) {
		LOG.info("demarrage de l'application");
		Contexte ctx = Contexte.getInstance();
		try {
			if (ctx.getSession("metier")==null){
				FacadeMetier f = new FacadeMetier();	
				ctx.setSession("metier", f);
			}
			return new Reponse("menu");
		} catch(Exception e){
			Reponse rep = new Reponse("erreurApplication");
			rep.setAttribut("errMsg", "Erreur a l'instanciation de l'application :" +e.getMessage());
			return rep;
		}
	}
}
