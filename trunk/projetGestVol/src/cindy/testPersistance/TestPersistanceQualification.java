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
	 * Méthode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOQualification();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}
	
	/**
	 * Méthode de test sur la lecture de la table Qualification de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
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
	
	/**
	 * Méthode de test sur l'insertion des données de la table Qualification de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
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

	/**
	 * Méthode de test sur la modification des données de la table Qualification de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOQualification() {
		try {
			setUp();
			daoq.modifierPersistance(1, "Grand Poulet");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	/**
	 * Méthode de test sur un cas où une mauvaise insertion des données de la table Qualification s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOQualification() {
		try {
			setUp();
			daoq.insererPersistance("Grand coq", "Grand Poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des données geré"+ e.getMessage(), true);
		}
	}	

	/**
	 * Méthode de test sur un cas où une mauvaise modification des données de la table Qualification s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOQualification() {
		try {
			setUp();
			daoq.modifierPersistance(1,23);
			fail("Données modifier non correct non geré ");
		} catch (Exception e) {
			assertTrue("Modification des données geré"+ e.getMessage(), true);
		}
	}	

	/**
	 * Méthode de test sur la suppression des données de la table Qualification de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
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

	/**
	 * Méthode de test sur un cas où une mauvaise suppression des données de la table Qualification s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
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

