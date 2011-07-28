package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.personnel.Equipage;
import cindy.metier.personnel.PersonnelNavigant;
import cindy.metier.personnel.Qualification;

/**
 * Test sur l'utilisation des methodes publiques d'un equipage.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestEquipage {

	private PersonnelNavigant persNavi = new PersonnelNavigant(23, "Pignouf",
			"Robert", "SGT", "deLaMort", Qualification.PC, 12);
	private PersonnelNavigant persPil = new PersonnelNavigant(43, "toto",
			"tata", "SGT", "deLaMort", Qualification.PC, 12);;

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Méthode de test qui va permettre de vérifier si tous les paramètres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Equipage(this.persPil, this.persNavi);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si juste un seul parametre
	 * fonctionne. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorUnPilote() {
		try {
			new Equipage(persPil);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier le cas où il n'y a pas
	 * d'ajout d'heure. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	public void testmajHeureAZero() {
		try {
			Equipage eq = new Equipage(persPil, persNavi);
			eq.majHeureVol(0);
			fail("Ajoute de l'heure à zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure à zero impossible gérée erreur"
							+ e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier le cas où il n'y a pas
	 * d'ajout d'heure pour le navigateur. Englober dans un try catch, affichage
	 * du message de l'exception.
	 */
	public void testmajHeureAZeroNaviNull() {
		try {
			Equipage eq = new Equipage(persNavi, null);
			eq.majHeureVol(0);
			fail("Ajoute de l'heure à zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure à zero impossible gérée erreur"
							+ e.getMessage(), true);
		}
	}

}
