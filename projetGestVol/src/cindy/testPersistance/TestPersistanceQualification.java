package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOQualification;


/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une qualification.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceQualification {

	private DAOQualification daoq;

	@Before
	public void setUp() throws Exception {
		daoq = new DAOQualification();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOQualification();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}
 
	@Test
	public void testLectureDAOQualification() {
		try {
			setUp();
			daoq.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance(1, "Grand Poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance(1, "Grand Poulet");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance("Grand coq", "Grand Poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOQualification() {
		try {
			setUp();
			daoq.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOQualification() {
		try {
			setUp();
			daoq.supprimerPersistance("Grand Poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}

