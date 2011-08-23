package gestdepartement.vues;

import org.apache.log4j.Logger;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Reponse;

public class VueErreur implements IVue {
	/** l'acces au logger. */
	private static final Logger LOG = Logger.getLogger(VueErreur.class);

	@Override
	public void actualise(Reponse rep) {
		initialise(rep, null);
	}

	@Override
	public void initialise(Reponse reponse, FacadeIhm facadeIhm) {
		LOG.error(reponse.getAttribut("errMsg"));
		System.out.println("ERREUR\n"+reponse.getAttribut("errMsg"));
	}
}
