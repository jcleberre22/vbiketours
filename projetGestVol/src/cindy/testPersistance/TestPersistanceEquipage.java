package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOEquipage;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un equipage.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceEquipage {

	private DAOEquipage daoe;

	@Before
	public void setUp() throws Exception {
		daoe = new DAOEquipage();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOEquipage();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	@Test
	public void testLectureDAOEquipage() {
		try {
			setUp();
			daoe.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testInsertionDAOEquipage() {
		try {
			setUp();
			daoe.insererPersistance(1, "Equipage de poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testModificationDAOEquipage() {
		try {
			setUp();
			daoe.insererPersistance(1, "Equipage de coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	@Test
	public void testMauvaiseInsertionDAOEquipage() {
		try {
			setUp();
			daoe.insererPersistance("coq", "Equipage de poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	@Test
	public void testSuppressionDAOEquipage() {
		try {
			setUp();
			daoe.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	@Test
	public void testMauvaiseSuppressionDAOEquipage() {
		try {
			setUp();
			daoe.supprimerPersistance("poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


}


