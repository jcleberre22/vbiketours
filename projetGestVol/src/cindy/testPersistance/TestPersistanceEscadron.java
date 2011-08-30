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

	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOEscadron();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Escadron de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOEscadron() {
		try {
			setUp();
			daoe.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur l'insertion des donn�es de la table Escadron de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAOEscadron() {
		try {
			setUp();
			daoe.insererPersistance(1, "Escadron de poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la modification des donn�es de la table Escadron de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOEscadron() {
		try {
			setUp();
			daoe.modifierPersistance(1, "Escadron de coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	/**
	 * M�thode de test sur un cas o� une mauvaise insertion des donn�es de la table Escadron s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOEscadron() {
		try {
			setUp();
			daoe.insererPersistance("coq", "Escadron de poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Escadron s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOEscadron() {
		try {
			setUp();
			daoe.modifierPersistance("coq", "Escadron de poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	/**
	 * M�thode de test sur la suppression des donn�es de la table Escadron de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOEscadron() {
		try {
			setUp();
			daoe.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Escadron s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOEscadron() {
		try {
			setUp();
			daoe.supprimerPersistance("Escadron poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


}

