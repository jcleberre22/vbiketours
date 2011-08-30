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

	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOQualification();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur la lecture de la table Qualification de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOQualification() {
		try {
			setUp();
			daoq.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur l'insertion des donn�es de la table Qualification de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance(1, "Grand Poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la modification des donn�es de la table Qualification de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOQualification() {
		try {
			setUp();
			daoq.modifierPersistance(1, "Grand Poulet");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	/**
	 * M�thode de test sur un cas o� une mauvaise insertion des donn�es de la table Qualification s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance("Grand coq", "Grand Poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Qualification s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOQualification() {
		try {
			setUp();
			daoq.modifierPersistance(1,23);
			fail("Donn�es modifier non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	/**
	 * M�thode de test sur la suppression des donn�es de la table Qualification de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOQualification() {
		try {
			setUp();
			daoq.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Qualification s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOQualification() {
		try {
			setUp();
			daoq.supprimerPersistance("Grand Poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


}

