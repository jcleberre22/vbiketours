package cindy.testPersistance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOCategorie;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une categorie de vol.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersitanceCategorie {

	private DAOCategorie daoc;
	
	@Before
	public void setUp() throws Exception {
		daoc = new DAOCategorie();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOCategorie();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOCategorie() {
		try {
			setUp();
			daoc.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}
	
	@Test
	public void testInsertionDAOCategorie() {
		try {
			setUp();
			daoc.insererPersistance(1, "poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}
	
	@Test
	public void testModificationDAOCategorie() {
		try {
			setUp();
			daoc.insererPersistance(1, "coq");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	
	
	@Test
	public void testMauvaiseInsertionDAOCategorie() {
		try {
			setUp();
			daoc.insererPersistance("poulet", "poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	
	
	@Test
	public void testSuppressionDAOCategorie() {
		try {
			setUp();
			daoc.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}
	
	@Test
	public void testMauvaiseSuppressionDAOCategorie() {
		try {
			setUp();
			daoc.supprimerPersistance("poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


	
}
