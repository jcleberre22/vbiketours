package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.avion.Armement;
import cindy.metier.avion.Avion;
import cindy.metier.comm.ISortieAerienne;
import cindy.metier.personnel.Equipage;
import cindy.metier.personnel.PersonnelNavigant;
import cindy.metier.vol.Evenement;
import cindy.metier.vol.Mission;
import cindy.metier.vol.SortieAerienne;
import cindy.metier.vol.Vol;

/**
 * Test de la sortie aérienne.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 27/07/2011
 */
public class TestSortieAerienne {

	private ISortieAerienne sortie;
	private GregorianCalendar dateAtterissage;
	private GregorianCalendar dateDecollage;
	private Vol vol = new Vol();
	private Evenement ev = new Evenement("nomEvent", "typeEvent");

	@Before
	public void setUp() throws Exception {
		dateAtterissage = new GregorianCalendar(2011, 5, 12);
		dateDecollage = new GregorianCalendar(2011, 5, 25);
		sortie = new SortieAerienne(new Avion("immat", "nom", "type", true),
				"debrief", new Armement(), new ArrayList<Evenement>(),
				new Equipage(new PersonnelNavigant()), new Mission("type",
						"description"), vol, dateDecollage, dateAtterissage);
	}

	@Test
	public void testConstructSA() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "debrief",
					new Armement(), new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, dateAtterissage);
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructSAAvionNull() {
		try {
			sortie = new SortieAerienne(null, "debrief", new Armement(),
					new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSADebNull() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), null,
					new Armement(), new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSADebVide() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "",
					new Armement(), new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSAArmNull() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "debrief", null,
					new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSAEquipageNull() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "debrief",
					new Armement(), new ArrayList<Evenement>(), null,
					new Mission("test", "description"), vol, dateDecollage,
					dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSADateDecoNull() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "debrief",
					new Armement(), new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, null, dateAtterissage);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testConstructSADateAtteNull() {
		try {
			sortie = new SortieAerienne(
					new Avion("immat", "nom", "type", true), "debrief",
					new Armement(), new ArrayList<Evenement>(), new Equipage(
							new PersonnelNavigant()), new Mission("test",
							"description"), vol, dateDecollage, null);
			fail("erreur d'instanciation");
		} catch (Exception e) {
			assertTrue("instanciation reussi" + e.getMessage(), true);
		}
	}

	@Test
	public void testAjouterEvent() {
		try {
			sortie.ajouterEvenement(ev);
			assertTrue("Ajout ok", true);
		} catch (Exception e) {
			fail("Probleme d'ajout" + e.getMessage());
		}
	}

	@Test
	public void testSuppressionEvent() {
		try {
			sortie.retirerEvenement(ev);
			assertTrue("Ajout ok", true);
		} catch (Exception e) {
			fail("Probleme d'ajout" + e.getMessage());
		}
	}

}
