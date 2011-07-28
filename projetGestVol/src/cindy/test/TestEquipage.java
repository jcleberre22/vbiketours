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
	 * M�thode de test qui va permettre de v�rifier si tous les param�tres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Equipage(this.persPil, this.persNavi);
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si juste un seul parametre
	 * fonctionne. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorUnPilote() {
		try {
			new Equipage(persPil);
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� il n'y a pas
	 * d'ajout d'heure. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	public void testmajHeureAZero() {
		try {
			Equipage eq = new Equipage(persPil, persNavi);
			eq.majHeureVol(0);
			fail("Ajoute de l'heure � zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure � zero impossible g�r�e erreur"
							+ e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� il n'y a pas
	 * d'ajout d'heure pour le navigateur. Englober dans un try catch, affichage
	 * du message de l'exception.
	 */
	public void testmajHeureAZeroNaviNull() {
		try {
			Equipage eq = new Equipage(persNavi, null);
			eq.majHeureVol(0);
			fail("Ajoute de l'heure � zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure � zero impossible g�r�e erreur"
							+ e.getMessage(), true);
		}
	}

}
