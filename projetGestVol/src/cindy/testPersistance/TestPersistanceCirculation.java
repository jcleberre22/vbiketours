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
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOCirculation() {
		try {
			setUp();
			daoc.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance(1, "Vol de poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance(1, "Vol de coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance("coq", "poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOCirculation() {
		try {
			setUp();
			daoc.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOCirculation() {
		try {
			setUp();
			daoc.supprimerPersistance("poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


}


