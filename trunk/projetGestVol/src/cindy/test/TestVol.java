package cindy.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import cindy.metier.avion.Armement;
import cindy.metier.avion.Avion;
import cindy.metier.personnel.Equipage;
import cindy.metier.personnel.PersonnelNavigant;
import cindy.metier.vol.Evenement;
import cindy.metier.vol.Mission;
import cindy.metier.vol.SortieAerienne;
import cindy.metier.vol.Vol;

/**
 * Test sur l'utilisation des methodes publiques d'un vol.
 * 
 * @author Jp.martinez
 * @version 1.0 du 26/07/2011
 */
public class TestVol extends TestCase {

	// attributs

	Avion avion = new Avion("4558DF66", "combat", "Rafale", true);
	Armement arm = new Armement(0);
	Equipage equipage = new Equipage(new PersonnelNavigant(),
			new PersonnelNavigant());
	Mission mission = new Mission("combat", "description");
	List<Evenement> lst = new ArrayList<Evenement>();
	String chaine = "test";
	List<SortieAerienne> listSortiesAeriennes = new ArrayList<SortieAerienne>();
	SortieAerienne sa;
	Vol monVol;

	/**
	 * m�thode appel�e au d�marrage du test
	 */
	protected void setUp() throws Exception {
		monVol = new Vol("A41D", "civile", 1, listSortiesAeriennes,
				new GregorianCalendar(2011, 5, 12), new GregorianCalendar(2011,
						5, 28));
		sa = new SortieAerienne(avion, chaine, arm, lst, equipage, mission,
				new GregorianCalendar(2011, 5, 12), new GregorianCalendar(2011,
						5, 28));
	}

	/**
	 * m�thode de teste du constructeur test d'un type de vol erron�
	 */
	@Test
	public void testerConstructeurVol() {
		try {
			new Vol("A56GF", "transport", 1, listSortiesAeriennes,
					new GregorianCalendar(2011, 5, 12), new GregorianCalendar(
							2011, 5, 28));
			fail("le test de la classe vol a �chou� : transport n'exsite pas");
		} catch (Exception e) {
			assertTrue(
					"l'instanciation du vol est correcte : " + e.getMessage(),
					true);
		}
	}

	/**
	 * deuxi�me m�thode de test du constructeur test d'une valeur nulle dans le
	 * constructeur
	 */
	@Test
	public void testConstructeurVolErr() {
		try {
			new Vol(null, null, -1, null, null, null);
			fail("d�claration d'un vol sans r�f�rence non g�r�");
		} catch (Exception e) {
			assertTrue(
					"la d�claration a march� malgr� la valeur null : "
							+ e.getMessage(), true);
		}
	}

	/**
	 * m�thode de test de la m�thode ajouter une sortie aerienne a un vol
	 * 
	 */
	@Test
	public void testerMethodesVol() {
		try {
			monVol.ajouterSortieAerienne(null);
			fail("tentative d'ajout d'un objet null ");
		} catch (Exception e) {
			assertTrue("Le test de la methode du vol est concluante", true);
		}
	}

	@Test
	public void testerModifierSortie() {
		try {
			SortieAerienne newSortie = new SortieAerienne(new Avion("75df4",
					"combat", "Mirage2000N", true), null, new Armement(), null,
					new Equipage(new PersonnelNavigant()), new Mission("type",
							"description"), new GregorianCalendar(),
					new GregorianCalendar());
			monVol.modifierSortieAerienne(newSortie, sa);
			fail("la modification a echou� car tentative de modifier une sortie qui n'existe pas");
		} catch (Exception e) {
			assertTrue("la modification a reussi", true);
		}
	}

	@Test
	public void testerModifierSortieErr() {
		try {
			SortieAerienne sortieNull = new SortieAerienne(null, "mon debrif",
					null, lst, null, null, null, null);
			monVol.modifierSortieAerienne(sa, sortieNull);
			fail("Impossible de modifier une sortie aerienne avec ses param�tres null");
		} catch (Exception e) {
			assertTrue("la modification est un succ�s" + e.getMessage(), true);
		}

	}

	@Test
	public void testerAjouterSortieErr() {
		try {
			monVol.ajouterSortieAerienne(sa);
			monVol.ajouterSortieAerienne(sa);
			fail("Tentative d'ajout d'une sortie d�j� r�f�renc�e");
		} catch (Exception e) {
			assertTrue("l'insertion d'une donn�e existante a fonctionn�", true);
		}
	}

	@Test
	public void testerSupprimerSortie() {
		try {
			monVol.supprimerSortieAerienne(sa);
			monVol.supprimerSortieAerienne(sa);
			fail("vous avez tent� de supprimer une sortie qui n'existe pas ou plus!!");
		} catch (Exception e) {
			assertTrue("la double suppression a r�ussi", true);
		}
	}

	@Test
	public void testerSuppressionNulle() {
		try {
			monVol.supprimerSortieAerienne(null);
			fail("la suppression de la sortie nulle a �chou�");
		} catch (Exception e) {
			assertTrue("la suppression de la sortie nulle a r�ussi", true);
		}
	}

}
