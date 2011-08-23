package gestdepartement.navigation;

import gestdepartement.metier.FacadeMetier;
import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.IControleur;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class InformationDept implements IControleur{


	public Reponse construireReponse(Requete requete) {
		Contexte ctx = Contexte.getInstance();
		Object obj = ctx.getSession("metier");
		FacadeMetier fac = (FacadeMetier) obj;
		Object code = requete.getParametre("saisie");
		
		if (code != null){
			String info = fac.getDepartement(code.toString());
			String[] champs = info.split(";");
			Reponse rep = new Reponse("vueDept");
			rep.setAttribut("codeDept", champs[0]);
			rep.setAttribut("nomDept", champs[1]);
			rep.setAttribut("nombreHabitant", champs[2]);
			rep.setAttribut("superficie", champs[3]);
			rep.setAttribut("densite", champs[4]);
			rep.setAttribut("region", champs[5]);
			return rep;
		}
		return null;
	}

}
