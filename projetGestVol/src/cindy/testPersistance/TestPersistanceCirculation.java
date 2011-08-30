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

	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOCirculation();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Circulation de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
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

	/**
	 * M�thode de test sur l'insertion des donn�es de la table Circulation de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
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

	/**
	 * M�thode de test sur la modification des donn�es de la table Circulation de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOCirculation() {
		try {
			setUp();
			daoc.modifierPersistance(1, "Vol de coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	/**
	 * M�thode de test sur un cas o� une mauvaise insertion des donn�es de la table Circulation s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOCirculation() {
		try {
			setUp();
			daoc.insererPersistance("coq", "poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Circulation s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOCirculation() {
		try {
			setUp();
			daoc.modifierPersistance(1, 12);
			fail("Donn�es modifier non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise modification des donn�es ger�"+ e.getMessage(), true);
		}
	}

	/**
	 * M�thode de test sur la suppression des donn�es de la table Circulation de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
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

	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Circulation s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
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


