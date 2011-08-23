package gestdepartement.vues;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Reponse;

public class ConsulterDept implements IVue {

	@Override
	public void actualise(Reponse rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialise(Reponse reponse, FacadeIhm facadeIhm) {
		afficheInfo(reponse);
		
	}

	private void afficheInfo(Reponse rep) {
		System.out.println("Consultation d'un departement ");
		System.out.println("Code :" + rep.getAttribut("codeDept").toString());
		System.out.println("Nom :" + rep.getAttribut("nomDept").toString());
		System.out.println("Population :" + rep.getAttribut("nombreHabitant").toString());
		System.out.println("Superficie :" + rep.getAttribut("superficie").toString());
		System.out.println("Densite :" + rep.getAttribut("densite").toString());
		System.out.println("Region :" + rep.getAttribut("region").toString());
		
		
	}

}
