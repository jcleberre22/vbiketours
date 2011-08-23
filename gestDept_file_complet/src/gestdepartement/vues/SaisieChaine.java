package gestdepartement.vues;

import java.util.Scanner;

import org.apache.log4j.Logger;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class SaisieChaine implements IVue {
	/** l'acces au logger. */
	private static final Logger LOG = Logger.getLogger(SaisieChaine.class);


	public void actualise(Reponse rep) {
		LOG.debug("SaisieChaine actualise");
		traitementSaisie(rep);
	}

	public void initialise(Reponse reponse, FacadeIhm facadeIhm) {
		LOG.debug("SaisieChaine initialise");
		traitementSaisie(reponse);
	}

	private void traitementSaisie(Reponse rep) {
		Object inv = rep.getAttribut("invite");
		if (inv != null){
			System.out.print(inv);
		}
		Scanner sc = new Scanner(System.in);
		String ret = sc.nextLine();
		
		Requete req = new Requete(null,rep);
		
		if (ret.trim().length() > 0) {
			req.setParametre("saisie", ret);
			req.requestDispatcher(null, "ok");
		} else {
			req.requestDispatcher(null, "annul");
		}
	}
}
