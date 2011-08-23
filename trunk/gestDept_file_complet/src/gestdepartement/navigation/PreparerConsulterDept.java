package gestdepartement.navigation;

import org.apache.log4j.Logger;

import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

/**
 * Redirection simple sur l'ecran de saisie du numero de 
 * departement a consulter.
 * @author marc.leconte
 * @version 1.0
 */
public class PreparerConsulterDept implements IControleur{
	private static final Logger LOG = Logger.getLogger(PreparerConsulterDept.class);

	@Override
	public Reponse construireReponse(Requete requete) {
		LOG.debug("demande la saisie du departement a consulter");
		Reponse rep = new Reponse("saisieCodeDept");
		rep.setAttribut("invite", "Saisissez le code du departement a consulter :");
		return rep;
	}
}
