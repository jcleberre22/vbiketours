package gestdepartement.vues;

import java.util.Scanner;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Contexte;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;

public class MenuRegion implements IVue {
	private static final String TITRE = "   Gestion de la region ";
	private static final String MENU =	"---------------------------------------\n" +
		"1. Supprimer cette region\n" +
		"2. Modifier le nom de cette region\n" +
		"3. Ajouter un departement\n" +
		"4. Lister les departements de la region\n" +
		"5. Modifier un departement de la region\n" +
		"6. Supprimer un departement de la region\n" +
		"0. Quitter\n\n" +
		" Votre choix :>";

	private static final String[] OPTIONS_POSSIBLE = {"quitter","supprimerRegion","modifierRegion",
		"ajouterDepartement","listerDepartement","modifierDepartement","supprimerDepartement"};
	
	public void actualise(Reponse rep) {
		afficherMenu();
	}

	public void initialise(Reponse reponse, FacadeIhm facadeIhm) {
		afficherMenu();
		int chx = choixUser();
		Requete req = new Requete(null, reponse);
		req.requestDispatcher(null, OPTIONS_POSSIBLE[chx]);
	}
	
	//METHODES PRIVEES
	private int choixUser() {
		int ret = -1;
		Scanner scan = new Scanner(System.in);
		
		do {
			String choix = scan.nextLine();
			try {
				int iChoix = Integer.parseInt(choix);
				if (iChoix >= 0 && iChoix < OPTIONS_POSSIBLE.length) {
					ret = iChoix;
				} else {
					System.out.println("Vous devez saisir un chiffre entre [0," +
							OPTIONS_POSSIBLE.length + "]");
					System.out.print(" Votre choix :>");
				}
			} catch (Exception e) {
				System.out.println("Vous devez saisir un chiffre !!");
			}
		} while(ret == -1);
		return ret;
	}

	private void afficherMenu() {
		Contexte ctx = Contexte.getInstance();
		Object ob = ctx.getSession("nomRegion");
		System.out.println(TITRE+ob);
		System.out.println(MENU);
	}
}
