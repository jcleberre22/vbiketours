package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOEvenement;


/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un evenement.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceEvenement {

	private DAOEvenement daoe;

	@Before
	public void setUp() throws Exception {
		daoe = new DAOEvenement();
	}

	@Test
	public void testConstructor() {
		try {
			new DAOEvenement();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testLectureDAOEvenement() {
		try {
			setUp();
			daoe.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Evenement de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testInsertionDAOEvenement() {
		try {
			setUp();
			daoe.insererPersistance(1, "Plumage de poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur l'insertion des donn�es de la table Evenement de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testModificationDAOEvenement() {
		try {
			setUp();
			daoe.modifierPersistance(1, "Plumage de coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	/**
	 * M�thode de test sur la modification des donn�es de la table Evenement de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseInsertionDAOEvenement() {
		try {
			setUp();
			daoe.insererPersistance("Tueur de coq", "Plumage de poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise insertion des donn�es de la table Evenement s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseModificationDAOEvenement() {
		try {
			setUp();
			daoe.modifierPersistance(1,23);
			fail("Donn�es modifi� non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	/**
	 * M�thode de test sur la suppression des donn�es de la table Evenement de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOEvenement() {
		try {
			setUp();
			daoe.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Evenement s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOEvenement() {
		try {
			setUp();
			daoe.supprimerPersistance("Plumage de poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


}

