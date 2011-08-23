package gestdepartement.vues;

import java.util.List;
import java.util.Scanner;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class ChoixRegion implements IVue {
	private List<String> lesRegions;
	private Reponse reponse;
	@Override
	public void actualise(Reponse rep) {
		reponse = rep;
		exploiteReponse();
		demanderChoix();
	}

	@Override
	public void initialise(Reponse rep, FacadeIhm facadeIhm) {
		reponse = rep;
		exploiteReponse();
		demanderChoix();
	}

	private void demanderChoix() {
		System.out.println("Choisissez la region à gerer");
		System.out.println("----------------------------");

		int num = 1;
		for (String nomReg : lesRegions) {
			System.out.printf("%3d %s\n" ,num++, nomReg);
		}
		System.out.print("\n  0 Revenir au menu\nSaisissez le numero de la region voulue :>");
		saisirChoix();
	}

	private void saisirChoix() {
		int ret = -1;
		Scanner sc = new Scanner(System.in);
		do {
			String saisie = sc.nextLine();
			try {
				int chx = Integer.parseInt(saisie);
				if (chx >= 0 || chx  < lesRegions.size()+1){
					ret = chx;
				} else {
					System.out.println("Vous devez saisir un chiffre entre 0 et "+ (lesRegions.size()+1));
				}
			} catch (Exception e){
				System.out.println("Vous devez saisir un chiffre !! ");
			}
		} while(ret == -1);
		Requete req = new Requete(null,reponse);
		if (ret > 0){
			req.setParametre("nomRegion",lesRegions.get(ret-1));
			req.requestDispatcher(null, "gererRegion");
			return ;
		}
		req.requestDispatcher(null, "annul");
	}

	@SuppressWarnings("unchecked")
	private void exploiteReponse() {
		Object ob = reponse.getAttribut("regions");
		if (ob == null ){
			System.out.println("Aucune region presente !!");
			return;
		}
		lesRegions = (List<String>) ob;
	}

}
