package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOMission;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une mission.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceMission {

	private DAOMission daom;

	@Before
	public void setUp() throws Exception {
		daom = new DAOMission();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOMission();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOMission() {
		try {
			setUp();
			daom.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOMission() {
		try {
			setUp();
			daom.insererPersistance(1, "Capturer les poulets");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOMission() {
		try {
			setUp();
			daom.insererPersistance(1, "Capturer des coqs");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOMission() {
		try {
			setUp();
			daom.insererPersistance("Capturer des coqs", "Capturer les poulets");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOMission() {
		try {
			setUp();
			daom.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOMission() {
		try {
			setUp();
			daom.supprimerPersistance("Capturer les poulets");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}

