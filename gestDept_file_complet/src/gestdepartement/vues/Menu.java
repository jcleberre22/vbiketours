package gestdepartement.vues;

import java.util.Scanner;

import org.apache.log4j.Logger;

import protocolreqrep.ihm.FacadeIhm;
import protocolreqrep.ihm.IVue;
import protocolreqrep.navigation.Reponse;
import protocolreqrep.navigation.Requete;
/**
 * Affichage du menu prinicpal et attente du
 * choix utilisateur.
 * @author marc.leconte
 * @version 1.0 du 14/06/2011
 */
public class Menu implements IVue {
	/** l'acces au logger. */
	private static final Logger LOG = Logger.getLogger(Menu.class);
	private static final String MENU =
		"Menu de la gestion des departements\n" +
		"-----------------------------------\n" +
		"1. Consulter un departement\n" +
		"2. Gerer une region\n" +
		"0. Quitter\n\n" +
		" Votre choix :>";
	private static final String[] OPTIONS_POSSIBLE = {"quitter","consultDept","gereRegion"};
		
	/**
	 * Premier appel de la classe.
	 */
	public void initialise(Reponse reponse, FacadeIhm facadeIhm) {
		LOG.info("vue menu de l'application");
		actualise(reponse);
	}

	private int choixUser() {
		int ret = -1;
		Scanner scan = new Scanner(System.in);
		
		do {
			String choix = scan.nextLine();
			try {
				int iChoix = Integer.parseInt(choix);
				if (iChoix >= 0 && iChoix< OPTIONS_POSSIBLE.length) {
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
		System.out.println(MENU);
	}

	/**
	 * Appel suivant, il s'agit de remettre a jour les informations
	 * présentées.
	 * @param rep la reponse qui fait suite a la requete précédente.
	 */
	public void actualise(Reponse rep) {
		Requete req = new Requete(null, rep);
		afficherMenu();
		int chx = choixUser();
		req.requestDispatcher(null, OPTIONS_POSSIBLE[chx]);
	}

}
