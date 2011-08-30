package cindy.testPersistance;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOCirculation;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une circulation de vol.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceCirculation {


	private DAOCirculation daoc;

	@Before
	public void setUp() throws Exception {
		daoc = new DAOCirculation();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOCirculation();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOCirculation() {
		try {
			setUp();
			daoc.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance(1, "Vol de poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance(1, "Vol de coq");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance("coq", "poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOCirculation() {
		try {
			setUp();
			daoc.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOCirculation() {
		try {
			setUp();
			daoc.supprimerPersistance("poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}


