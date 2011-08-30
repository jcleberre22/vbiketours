package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOEscadron;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un escadron.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceEscadron {

	private DAOEscadron daoe;

	@Before
	public void setUp() throws Exception {
		daoe = new DAOEscadron();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOEscadron();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOEscadron() {
		try {
			setUp();
			daoe.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOEscadron() {
		try {
			setUp();
			daoe.insererPersistance(1, "Escadron de poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOEscadron() {
		try {
			setUp();
			daoe.insererPersistance(1, "Escadron de coq");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOEscadron() {
		try {
			setUp();
			daoe.insererPersistance("coq", "Escadron de poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOEscadron() {
		try {
			setUp();
			daoe.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOEscadron() {
		try {
			setUp();
			daoe.supprimerPersistance("Escadron poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}

