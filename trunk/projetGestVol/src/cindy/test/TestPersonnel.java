package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.comm.IPersonnelNaviguant;
import cindy.metier.personnel.PersonnelNaviguant;
import cindy.metier.personnel.Qualification;

/**
 * Test sur l'utilisation des methodes publiques d'un personnelNaviguant.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */

public class TestPersonnel {

	private IPersonnelNaviguant persNavi;

	@Before
	public void setUp() throws Exception {
		persNavi = new PersonnelNaviguant();
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si tous les param�tres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'un id n�gatif
	 * est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorIdNegatif() {
		try {
			new PersonnelNaviguant(-1, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre ID � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre ID � null g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'un nom null est
	 * g�r�. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorNomNull() {
		try {
			new PersonnelNaviguant(23, null, "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre nom � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre nom � null g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'un prenom null
	 * est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorPrenomNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", null, "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre prenom � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre prenom � null g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'un grade null
	 * est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorGradeNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", null, "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre grade � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre grade � null g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'un escadron null
	 * est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorEscadronNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", null,
					Qualification.PC, 12);
			fail("Param�tre escadron � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre escadron � null g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'une
	 * qualification null est g�r�. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorQualificationNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					null, 12);
			fail("Param�tre qualification � null non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre qualification � null g�r�e" + e.getMessage(),
					true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'une heure de vol
	 * 0 est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorHeureVolZero() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 0);
			fail("Param�tre heure � 0 non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre heure � 0 g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si le cas d'une heure de vol
	 * 0 est g�r�. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorHeureVolNegatif() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, -1);
			fail("Param�tre heure negatif non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre heure negatif g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si l'ajout des heures
	 * fonctionnent correctement. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testAjouterHeureOk() {
		try {
			persNavi.ajouterNbHeure(25);
			assertTrue("Ajout nombre heure OK", true);
		} catch (Exception e) {
			fail("Ajout nombre heure FAILED :" + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur le param�tre prenom. V�rifie si le cas d'un champ vide
	 * est g�r�. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorNomVide() {
		try {
			new PersonnelNaviguant(23, "", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre nom non renseign� non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre nom non renseign� g�r�e" + e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test sur le param�tre prenom. V�rifie si le cas d'un champ vide
	 * est g�r�. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorPrenomVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre prenom non renseign� non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre prenom non renseign� g�r�e" + e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test sur le param�tre grade. V�rifie si le cas d'un champ vide
	 * est g�r�. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorGradeVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "", "deLaMort",
					Qualification.PC, 12);
			fail("Param�tre grade non renseign� non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre grade non renseign� g�r�e" + e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test sur le param�tre escadron. V�rifie si le cas d'un champ vide
	 * est g�r�. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorEscadronVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "",
					Qualification.PC, 12);
			fail("Param�tre escadron non renseign� non g�r�e");
		} catch (Exception e) {
			assertTrue("Param�tre escadron non renseign� g�r�e" + e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier si l'ajout des heures
	 * n�gatives se met en erreur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testAjouterHeureNegatif() {
		try {
			persNavi.ajouterNbHeure(-25);
			fail("Impossible d'ajouter des heures n�gatives ");

		} catch (Exception e) {
			assertTrue("Impossible d'ajouter des heures n�gatives g�r�e erreur"
					+ e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� il n'y a pas
	 * d'ajout d'heure. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testAjouterHeureAZero() {
		try {
			persNavi.ajouterNbHeure(0);
			fail("Ajoute de l'heure � zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure � zero impossible g�r�e erreur"
							+ e.getMessage(), true);
		}
	}

}
