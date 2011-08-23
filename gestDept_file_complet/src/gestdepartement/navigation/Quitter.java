package gestdepartement.navigation;


import gestdepartement.metier.FacadeMetier;

import org.apache.log4j.Logger;

import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class Quitter implements IControleur{
	private static final Logger LOG = Logger.getLogger(Quitter.class);

	@Override
	public Reponse construireReponse(Requete requete) {
		LOG.info("arret de l'application");
		Contexte ctx = Contexte.getInstance();
		Object obj = ctx.getSession("metier");
		FacadeMetier fac = (FacadeMetier) obj;
		fac.quitter();
		ctx.fermer();
		/*
		System.out.println("Exemple exploitation de la facade");
		
		List<IDepartementConsultable> ret = fac.listerDepartementTries();
		for (IDepartementConsultable departement : ret) {
			System.out.println(departement);
		}
		*/
		return null;
	}
}