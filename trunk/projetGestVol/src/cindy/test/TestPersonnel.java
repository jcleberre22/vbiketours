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
	 * Méthode de test qui va permettre de vérifier si tous les paramètres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'un id négatif
	 * est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorIdNegatif() {
		try {
			new PersonnelNaviguant(-1, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre ID à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre ID à null gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'un nom null est
	 * géré. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorNomNull() {
		try {
			new PersonnelNaviguant(23, null, "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre nom à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre nom à null gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'un prenom null
	 * est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorPrenomNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", null, "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre prenom à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre prenom à null gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'un grade null
	 * est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorGradeNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", null, "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre grade à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre grade à null gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'un escadron null
	 * est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorEscadronNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", null,
					Qualification.PC, 12);
			fail("Paramètre escadron à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre escadron à null gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'une
	 * qualification null est géré. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorQualificationNull() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					null, 12);
			fail("Paramètre qualification à null non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre qualification à null gérée" + e.getMessage(),
					true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'une heure de vol
	 * 0 est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorHeureVolZero() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, 0);
			fail("Paramètre heure à 0 non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre heure à 0 gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le cas d'une heure de vol
	 * 0 est géré. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorHeureVolNegatif() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "deLaMort",
					Qualification.PC, -1);
			fail("Paramètre heure negatif non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre heure negatif gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si l'ajout des heures
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
	 * Méthode de test sur le paramètre prenom. Vérifie si le cas d'un champ vide
	 * est géré. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorNomVide() {
		try {
			new PersonnelNaviguant(23, "", "Robert", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre nom non renseigné non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre nom non renseigné gérée" + e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test sur le paramètre prenom. Vérifie si le cas d'un champ vide
	 * est géré. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorPrenomVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "", "SGT", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre prenom non renseigné non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre prenom non renseigné gérée" + e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test sur le paramètre grade. Vérifie si le cas d'un champ vide
	 * est géré. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorGradeVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "", "deLaMort",
					Qualification.PC, 12);
			fail("Paramètre grade non renseigné non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre grade non renseigné gérée" + e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test sur le paramètre escadron. Vérifie si le cas d'un champ vide
	 * est géré. Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructorEscadronVide() {
		try {
			new PersonnelNaviguant(23, "Pignouf", "Robert", "SGT", "",
					Qualification.PC, 12);
			fail("Paramètre escadron non renseigné non gérée");
		} catch (Exception e) {
			assertTrue("Paramètre escadron non renseigné gérée" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si l'ajout des heures
	 * négatives se met en erreur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testAjouterHeureNegatif() {
		try {
			persNavi.ajouterNbHeure(-25);
			fail("Impossible d'ajouter des heures négatives ");

		} catch (Exception e) {
			assertTrue("Impossible d'ajouter des heures négatives gérée erreur"
					+ e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier le cas où il n'y a pas
	 * d'ajout d'heure. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testAjouterHeureAZero() {
		try {
			persNavi.ajouterNbHeure(0);
			fail("Ajoute de l'heure à zero impossible ");

		} catch (Exception e) {
			assertTrue(
					"Ajoute de l'heure à zero impossible gérée erreur"
							+ e.getMessage(), true);
		}
	}

}
